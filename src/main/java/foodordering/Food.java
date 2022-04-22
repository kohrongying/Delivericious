package foodordering;

import java.math.BigDecimal;

public abstract class Food {
    String name;
    Money price;

    public Food(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}

