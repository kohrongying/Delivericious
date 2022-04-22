package foodordering.food;

import foodordering.Food;

import java.math.BigDecimal;

public class ChocolateIceCream extends Food {

    public static final String NAME = "chocolate ice cream";
    public static final BigDecimal PRICE = new BigDecimal("4.00");

    public ChocolateIceCream() {
        super(NAME, PRICE);
    }
}
