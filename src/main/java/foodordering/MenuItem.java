package foodordering;

import java.util.Objects;
import java.util.UUID;

public class MenuItem {
    private UUID id = UUID.randomUUID();
    private String name;
    private Money price;

    public MenuItem(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem that = (MenuItem) o;
        return Objects.equals(id, that.id);
    }
}
