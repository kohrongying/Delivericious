package foodordering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<BasketItem> itemList = new ArrayList<>();

    public void addFood(Food food) {
        this.addFood(food, 1);
    }
    public void addFood(Food food, int quantity) {
        this.itemList.add(new BasketItem(food, quantity));
    }

    public List<BasketItem> getAllItems() {
        return this.itemList;
    }

    public BigDecimal getTotalPrice() {
        return itemList.stream()
                .map(BasketItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }
}

