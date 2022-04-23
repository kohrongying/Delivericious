package foodordering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    MenuItem tomatoSoup = new MenuItem("Tomato Soup", new Money("24.45", Currency.SGD));
    MenuItem seaMenuItemSalad = new MenuItem("SeaFood Salad", new Money("12.00", Currency.SGD));
    MenuItem iceCream = new MenuItem("Chocolate Ice Cream", new Money("4.00", Currency.SGD));

    @Test
    void testAddTomatoSoupToBasket() throws BasketQuantityExceedException {
        // given
        Basket basket = new Basket();

        // when
        BasketItem basketItem = new BasketItem(tomatoSoup);
        basket.addBasketItem(basketItem);

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), basketItem);
    }

    @Test
    void testAddSeaFoodSaladToBasket() throws BasketQuantityExceedException {
        // given
        Basket basket = new Basket();

        // when
        BasketItem basketItem = new BasketItem(seaMenuItemSalad);
        basket.addBasketItem(basketItem);

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), basketItem);
        assertEquals(new Money("12.00", Currency.SGD), basket.totalPrice());
    }

    @Test
    void testAdd3ChocolateIceCreamToBasket() throws BasketQuantityExceedException {
        // given
        Basket basket = new Basket();

        // when
        basket.addBasketItem(new BasketItem(iceCream, 3));

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        Integer totalFoodQuantity = basket.totalQuantity();
        assertEquals(1, actualItems.size());
        assertEquals(3, totalFoodQuantity);
        assertEquals(new Money("4.00", Currency.SGD), iceCream.getPrice());
        assertEquals(new Money("12.00", Currency.SGD), basket.totalPrice());
    }

    @Test
    void testRemoveChocolateIceCreamAfterAdd3ToBasket() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(iceCream, 3));

        basket.remove(iceCream, 1);

        List<BasketItem> actualBasketItemList = basket.getBasketItemList();
        Integer totalFoodQuantity = basket.totalQuantity();
        assertEquals(1, actualBasketItemList.size());
        assertEquals(2, totalFoodQuantity);
        assertEquals(new Money("4.00", Currency.SGD), iceCream.getPrice());
        assertEquals(new Money("8.00", Currency.SGD), basket.totalPrice());
    }

    @Test
    void testBasketDuplicateForReOrdering() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(iceCream, 3));

        Basket newBasket = basket.duplicate();

        assertNotEquals(basket.id(), newBasket.id());
        assertEquals(new Money("12.00", Currency.SGD), newBasket.totalPrice());
    }

    @Test
    void testBasketGetTotalPrice() throws BasketQuantityExceedException {
        Basket basket = new Basket();

        basket.addBasketItem(new BasketItem(iceCream, 3));
        basket.addBasketItem(new BasketItem(seaMenuItemSalad));

        assertEquals(new Money("24.00", Currency.SGD), basket.totalPrice());
    }

    @Test
    void testBasketThrowExceptionWhenAddBasketItemOfMoreThan100Quantity() {
        Basket basket = new Basket();
        assertThrows(BasketQuantityExceedException.class,
                () -> basket.addBasketItem(new BasketItem(iceCream, 101)));
    }

    @Test
    void testBasketThrowExceptionWhenTotalQuantityOfFoodExceed100AfterAddBasketItem() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(iceCream, 90));

        assertThrows(BasketQuantityExceedException.class,
                () -> basket.addBasketItem(new BasketItem(iceCream, 11)));
    }

}
