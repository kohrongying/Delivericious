package foodordering;

import foodordering.food.ChocolateIceCream;
import foodordering.food.SeaFoodSalad;
import foodordering.food.TomatoSoup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    Food tomatoSoup = new TomatoSoup();
    Food seaFoodSalad = new SeaFoodSalad();
    Food iceCream = new ChocolateIceCream();

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
        BasketItem basketItem = new BasketItem(seaFoodSalad);
        basket.addBasketItem(basketItem);

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), basketItem);
        assertEquals(new Money("12.00", Currency.SGD), basket.getTotalPrice());
    }

    @Test
    void testAdd3ChocolateIceCreamToBasket() throws BasketQuantityExceedException {
        // given
        Basket basket = new Basket();

        // when
        basket.addBasketItem(new BasketItem(iceCream, 3));

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        Integer totalFoodQuantity = basket.totalFoodQuantity();
        assertEquals(1, actualItems.size());
        assertEquals(3, totalFoodQuantity);
        assertEquals(new Money("4.00", Currency.SGD), iceCream.getPrice());
        assertEquals(new Money("12.00", Currency.SGD), basket.getTotalPrice());
    }

    @Test
    void testRemoveChocolateIceCreamAfterAdd3ToBasket() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(iceCream, 3));

        basket.removeFood(iceCream, 1);

        List<BasketItem> actualBasketItemList = basket.getBasketItemList();
        Integer totalFoodQuantity = basket.totalFoodQuantity();
        assertEquals(1, actualBasketItemList.size());
        assertEquals(2, totalFoodQuantity);
        assertEquals(new Money("4.00", Currency.SGD), iceCream.getPrice());
        assertEquals(new Money("8.00", Currency.SGD), basket.getTotalPrice());
    }

    @Test
    void testBasketDuplicateForReOrdering() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(iceCream, 3));

        Basket newBasket = basket.duplicate();

        assertNotEquals(basket.id(), newBasket.id());
        assertEquals(new Money("12.00", Currency.SGD), newBasket.getTotalPrice());
    }

    @Test
    void testBasketGetTotalPrice() throws BasketQuantityExceedException {
        Basket basket = new Basket();

        basket.addBasketItem(new BasketItem(iceCream, 3));
        basket.addBasketItem(new BasketItem(seaFoodSalad));

        assertEquals(new Money("24.00", Currency.SGD), basket.getTotalPrice());
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
