package foodordering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<BasketItem> basketItemList = new ArrayList<>();

    public void addBasketItem(BasketItem basketItem) {
        this.basketItemList.add(basketItem);
    }

    public List<BasketItem> getBasketItemList() {
        return this.basketItemList;
    }

    public Money getTotalPrice() {
        return basketItemList.stream()
            .map(BasketItem::getPrice)
            .reduce(Money.ZERO, Money::add);
    }
}

