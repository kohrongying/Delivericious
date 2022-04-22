package foodordering.food;

import foodordering.Food;

import java.math.BigDecimal;

public class TomatoSoup extends Food {

    public static final String TOMATO_SOUP = "Tomato Soup";
    public static final BigDecimal TOMATO_SOUP_PRICE = new BigDecimal("24.45");

    public TomatoSoup() {
        super(TOMATO_SOUP, TOMATO_SOUP_PRICE);
    }
}
