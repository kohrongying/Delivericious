package foodordering;

import java.math.BigDecimal;

public abstract class Food {
    String name;
    BigDecimal price;

    public Food(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

