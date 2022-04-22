package foodordering;

import java.math.BigDecimal;

public class BasketItem {
    private final int quantity;

    private final Food food;

    public BasketItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }
    public BigDecimal getTotalPrice() {
        return BigDecimal.valueOf(food.getPrice().doubleValue() * quantity);
    }

    public Food getFood() {
        return food;
    }
}
