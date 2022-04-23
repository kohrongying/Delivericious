package foodordering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Basket {
    public final UUID id;

    public Basket() {
        this.id = UUID.randomUUID();
    }

    private final List<BasketItem> basketItemList = new ArrayList<>();

    public void addBasketItem(BasketItem basketItem) {
        int newQuantity = this.totalFoodQuantity() + basketItem.getQuantity();
        if (newQuantity > 100) {
            throw new UnsupportedOperationException("Cannot add more than 100 items to basket");
        }
        this.basketItemList.add(basketItem);
    }

    public List<BasketItem> getBasketItemList() {
        return this.basketItemList;
    }

    public Money getTotalPrice() {
        return this.basketItemList.stream()
            .map(BasketItem::getPrice)
            .reduce(Money.ZERO, Money::add);
    }

    public Integer totalFoodQuantity() {
        return this.basketItemList.stream()
                .map(BasketItem::getQuantity)
                .reduce(0, Integer::sum);
    }

    public void removeFood(Food food, int quantityToDecrease) {
        List<BasketItem> result = this.basketItemList.stream()
                .filter(basketItem -> basketItem.getFood().equals(food))
                .collect(Collectors.toList());

        if (result.size() == 0) return;

        BasketItem foundBasketItem = result.get(0);
        Integer currentFoundBasketItemQuantity = foundBasketItem.getQuantity();
        Integer newBasketItemQuantity = currentFoundBasketItemQuantity - quantityToDecrease;
        this.removeBasketItem(foundBasketItem);

        if (newBasketItemQuantity == 0) return;
        this.addBasketItem(new BasketItem(foundBasketItem.getFood(), newBasketItemQuantity));
    }

    private void removeBasketItem(BasketItem basketItem) {
        this.basketItemList.remove(basketItem);
    }

    public Basket duplicate() {
        Basket newBasket = new Basket();
        for (int i = 0; i < this.basketItemList.size(); i++) {
            BasketItem basketItem = this.basketItemList.get(i);
            newBasket.addBasketItem(basketItem.clone());
        }
        return newBasket;
    }
}

