package repository;

import foodordering.Basket;
import java.util.UUID;

public interface IBasketRepository {
    void save(Basket basket);

    Basket getBasketById(UUID id);
}
