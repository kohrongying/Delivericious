package foodordering.food;

import foodordering.Currency;
import foodordering.Food;
import foodordering.Money;

public class SeaFoodSalad extends Food {

    public static final String NAME = "SeaFoodSalad";
    public static final Money PRICE = new Money("12.00", Currency.SGD);


    public SeaFoodSalad() {
        super(NAME, PRICE);
    }
}
