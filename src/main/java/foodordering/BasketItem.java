package foodordering;

import java.math.BigDecimal;

public class BasketItem {
    private Food food;
    private Integer quantity;

    public BasketItem(Food food, Integer quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public BasketItem(Food food) {
        this.food = food;
        this.quantity = 1;
    }

    public Money getPrice() {
        return this.food.getPrice().multiply(new BigDecimal(this.quantity));
    }
}