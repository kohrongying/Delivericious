package foodordering;

import java.util.Objects;
import java.util.UUID;

public abstract class Food {
    private UUID id;
    String name;
    Money price;

    public Food(String name, Money price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Food that = (Food) o;
        return Objects.equals(id, that.id);
    }
}

