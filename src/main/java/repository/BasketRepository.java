package repository;

import foodordering.Basket;

import java.util.HashMap;
import java.util.UUID;

public class BasketRepository implements IBasketRepository {
    private final HashMap<UUID, Basket> baskets = new HashMap<>();

    public void save(Basket basket) {
        this.baskets.put(basket.id(), basket);
    }

    public Basket getBasketById(UUID id) {
        return this.baskets.get(id);
    }
}
