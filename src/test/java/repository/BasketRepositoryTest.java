package repository;

import foodordering.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketRepositoryTest {
    public static final MenuItem tomatoSoup = new MenuItem("Tomato Soup", new Money("24.45", Currency.SGD));
    public static final MenuItem seaMenuItemSalad = new MenuItem("SeaFood Salad", new Money("12.00", Currency.SGD));
    public static final MenuItem iceCream = new MenuItem("Chocolate Ice Cream", new Money("4.00", Currency.SGD));

    @Test
    void testSaveBasketShouldReturnHashMap() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(iceCream, 90));
        BasketRepository basketRepository = new BasketRepository();

        basketRepository.save(basket);

        assertEquals(basketRepository.getBasketById(basket.id()), basket);
    }
}