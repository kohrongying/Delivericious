package foodordering;

import java.math.BigDecimal;

public class BasketItem {
    private MenuItem menuItem;
    private Integer quantity;

    public BasketItem(MenuItem menuItem, Integer quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public BasketItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.quantity = 1;
    }

    public Money price() {
        return this.menuItem.getPrice().multiply(new BigDecimal(this.quantity));
    }

    public Integer quantity() {
        return this.quantity;
    }

    public MenuItem menuItem() {
        return this.menuItem;
    }

    public BasketItem clone() {
        return new BasketItem(this.menuItem, this.quantity);
    }
}