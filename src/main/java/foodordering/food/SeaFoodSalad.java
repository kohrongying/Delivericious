package foodordering.food;

import foodordering.Food;

import java.math.BigDecimal;

public class SeaFoodSalad extends Food {

    public static final String SEA_FOOD_SALAD = "SeaFoodSalad";
    public static final BigDecimal SEA_FOOD_SALAD_PRICE = new BigDecimal("12.00");


    public SeaFoodSalad() {
        super(SEA_FOOD_SALAD, SEA_FOOD_SALAD_PRICE);
    }
}
