package foodordering;

import foodordering.food.ChocolateIceCream;
import foodordering.food.SeaFoodSalad;
import foodordering.food.TomatoSoup;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddFoodItemToBasketTest {
    @Test
    void testAddTomatoSoupToBasket() {
        // given
        Basket basket = new Basket();
        Food tomatoSoup = new TomatoSoup();

        // when
        basket.addFood(tomatoSoup);

        // then
        List<BasketItem> actualItems = basket.getAllItems();
        assertEquals(1, actualItems.size());
        assertEquals(tomatoSoup, actualItems.get(0).getFood());
    }

    @Test
    void testAddSeaFoodSaladToBasket() {
        // given
        Basket basket = new Basket();
        Food seaFoodSalad = new SeaFoodSalad();

        // when
        basket.addFood(seaFoodSalad);

        // then
        List<BasketItem> actualItems = basket.getAllItems();
        assertEquals(1, actualItems.size());
        assertEquals(seaFoodSalad, actualItems.get(0).getFood());
        assertEquals(seaFoodSalad.getPrice(), basket.getTotalPrice());
    }

    @Test
    void testAdd3ChocolateIceCreamToBasket() {
        // given
        Basket basket = new Basket();
        Food iceCream = new ChocolateIceCream();

        // when
        basket.addFood(iceCream, 3);

        // then
        List<BasketItem> actualItems = basket.getAllItems();
        assertEquals(1, actualItems.size());
        assertEquals(new BigDecimal("4.00"), iceCream.getPrice());
        assertEquals(new BigDecimal("12.00"), basket.getTotalPrice());
    }
}
