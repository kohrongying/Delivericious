package foodordering;

import foodordering.food.SeaFoodSalad;
import foodordering.food.TomatoSoup;
import org.junit.jupiter.api.Test;

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
}
