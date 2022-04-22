package foodordering;

import foodordering.food.ChocolateIceCream;
import foodordering.food.SeaFoodSalad;
import foodordering.food.TomatoSoup;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFoodItemToBasketTest {
    @Test
    void testAddTomatoSoupToBasket() {
        // given
        Basket basket = new Basket();
        Food tomatoSoup = new TomatoSoup();

        // when
        BasketItem basketItem = new BasketItem(tomatoSoup);
        basket.addBasketItem(basketItem);

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), basketItem);
    }

    @Test
    void testAddSeaFoodSaladToBasket() {
        // given
        Basket basket = new Basket();
        Food seaFoodSalad = new SeaFoodSalad();

        // when
        BasketItem basketItem = new BasketItem(seaFoodSalad);
        basket.addBasketItem(basketItem);

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), basketItem);
        assertEquals(seaFoodSalad.getPrice(), basket.getTotalPrice());
    }

    @Test
    void testAdd3ChocolateIceCreamToBasket() {
        // given
        Basket basket = new Basket();
        Food iceCream = new ChocolateIceCream();

        // when
        basket.addBasketItem(new BasketItem(iceCream, 3));

        // then
        List<BasketItem> actualItems = basket.getBasketItemList();
        assertEquals(actualItems.size(), 1);
        assertEquals(iceCream.getPrice(), new BigDecimal("4.00"));
        assertEquals(basket.getTotalPrice(), new BigDecimal("12.00"));
    }
}
