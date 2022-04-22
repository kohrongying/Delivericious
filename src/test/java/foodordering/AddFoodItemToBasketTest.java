package foodordering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFoodItemToBasketTest {
    @Test
    void testAddFoodItemToBasket() {
        // given
        Basket basket = new Basket();

        // when
        basket.addFoodItem("TomatoSoup");

        // then
        List<String> actualItems = basket.getFoodItems();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), "TomatoSoup");
    }
}
