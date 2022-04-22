package foodordering.food;

import foodordering.Currency;
import foodordering.Food;
import foodordering.Money;

public class ChocolateIceCream extends Food {

    public static final String NAME = "chocolate ice cream";
    public static final Money PRICE = new Money("4.00", Currency.SGD);

    public ChocolateIceCream() {
        super(NAME, PRICE);
    }
}
