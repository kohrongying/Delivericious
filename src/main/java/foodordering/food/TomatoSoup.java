package foodordering.food;

import foodordering.Currency;
import foodordering.Food;
import foodordering.Money;

public class TomatoSoup extends Food {

    public static final String NAME = "Tomato Soup";
    public static final Money PRICE = new Money("24.45", Currency.SGD);

    public TomatoSoup() {
        super(NAME, PRICE);
    }
}
