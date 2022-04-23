package foodordering;

import java.util.*;
import java.util.stream.Collectors;

public class Basket {
    public static final int BASKET_LIMIT = 100;
    private final UUID id = UUID.randomUUID();

    private final List<BasketItem> basketItemList = new ArrayList<>();

    public void addBasketItem(BasketItem basketItem) throws BasketQuantityExceedException {
        int newQuantity = this.totalQuantity() + basketItem.quantity();
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

    public Money totalPrice() {
        return this.basketItemList.stream()
            .map(BasketItem::price)
            .reduce(Money.ZERO, Money::add);
    }

    public Integer totalQuantity() {
        return this.basketItemList.stream()
                .map(BasketItem::quantity)
                .reduce(0, Integer::sum);
    }

    public void remove(MenuItem menuItem, int quantityToDecrease) throws BasketQuantityExceedException {
        Optional<BasketItem> result = this.basketItemList.stream()
                .filter(basketItem -> basketItem.menuItem().equals(menuItem))
                .findFirst();

        if (result.isEmpty()) return;

        BasketItem foundBasketItem = result.get();
        Integer currentFoundBasketItemQuantity = foundBasketItem.quantity();
        int newBasketItemQuantity = currentFoundBasketItemQuantity - quantityToDecrease;
        this.removeBasketItem(foundBasketItem);

        if (newBasketItemQuantity == 0) return;
        this.addBasketItem(new BasketItem(foundBasketItem.menuItem(), newBasketItemQuantity));
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

    public List<BasketItem> getBasketItemByCategory(FoodCategory foodCategory) {
        return this.basketItemList.stream()
                .filter(basketItem -> basketItem.belongsToFoodCategory(foodCategory))
                .collect(Collectors.toList());

    }
}

