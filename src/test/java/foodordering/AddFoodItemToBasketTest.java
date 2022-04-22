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
        basket.addFood(tomatoSoup);

        // then
        List<Food> actualItems = basket.getAllFood();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), tomatoSoup);
    }

    @Test
    void testAddSeaFoodSaladToBasket() {
        // given
        Basket basket = new Basket();
        Food seaFoodSalad = new SeaFoodSalad();

        // when
        basket.addFood(seaFoodSalad);

        // then
        List<Food> actualItems = basket.getAllFood();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), seaFoodSalad);
        assertEquals(seaFoodSalad.getPrice(), basket.getTotalPrice());
    }

    @Test
    void testAdd3ChocolateIceCreamToBasket() {
        // given
        Basket basket = new Basket();
        Food iceCream = new ChocolateIceCream();

        // when
        basket.addFood(iceCream);
        basket.addFood(iceCream);
        basket.addFood(iceCream);

        // then
        List<Food> actualItems = basket.getAllFood();
        assertEquals(actualItems.size(), 3);
        assertEquals(actualItems.get(0), iceCream);
        assertEquals(actualItems.get(1), iceCream);
        assertEquals(actualItems.get(2), iceCream);
        assertEquals(iceCream.getPrice(), new BigDecimal("4.00"));
        assertEquals(basket.getTotalPrice(), new BigDecimal("12.00"));
    }
}
