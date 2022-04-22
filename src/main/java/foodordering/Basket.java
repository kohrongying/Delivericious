package foodordering;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<String> foodItems = new ArrayList<>();

    public void addFoodItem(String foodItem) {
        this.foodItems.add(foodItem);
    }

    public List<String> getFoodItems() {
        return this.foodItems;
    }
}
