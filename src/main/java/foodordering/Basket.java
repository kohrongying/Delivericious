package foodordering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public List<Food> getAllFood() {
        return this.foodList;
    }

    public BigDecimal getTotalPrice() {
        return foodList.stream()
            .map(Food::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

