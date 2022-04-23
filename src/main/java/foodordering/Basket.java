package foodordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Basket {
    public static final int BASKET_LIMIT = 100;
    private final UUID id = UUID.randomUUID();

    private final List<BasketItem> basketItemList = new ArrayList<>();

    public void addBasketItem(BasketItem basketItem) throws BasketQuantityExceedException {
        int newQuantity = this.totalFoodQuantity() + basketItem.getQuantity();
        if (newQuantity > BASKET_LIMIT) {
            throw new BasketQuantityExceedException();
        }
        this.basketItemList.add(basketItem);
    }

    public List<BasketItem> getBasketItemList() {
        return this.basketItemList;
    }

    public UUID id() {
        return this.id;
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

    public void removeFood(Food food, int quantityToDecrease) throws BasketQuantityExceedException {
        Optional<BasketItem> result = this.basketItemList.stream()
                .filter(basketItem -> basketItem.getFood().equals(food))
                .findFirst();

        if (result.isEmpty()) return;

        BasketItem foundBasketItem = result.get();
        Integer currentFoundBasketItemQuantity = foundBasketItem.getQuantity();
        int newBasketItemQuantity = currentFoundBasketItemQuantity - quantityToDecrease;
        this.removeBasketItem(foundBasketItem);

        if (newBasketItemQuantity == 0) return;
        this.addBasketItem(new BasketItem(foundBasketItem.getFood(), newBasketItemQuantity));
    }

    private void removeBasketItem(BasketItem basketItem) {
        this.basketItemList.remove(basketItem);
    }

    public Basket duplicate() throws BasketQuantityExceedException {
        Basket newBasket = new Basket();
        for (int i = 0; i < this.basketItemList.size(); i++) {
            BasketItem basketItem = this.basketItemList.get(i);
            newBasket.addBasketItem(basketItem.clone());
        }
        return newBasket;
    }
}

