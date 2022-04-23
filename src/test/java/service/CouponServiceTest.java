package service;

import foodordering.*;
import org.junit.jupiter.api.Test;
import repository.CouponRepository;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CouponServiceTest {
    public static final MenuItem tomatoSoup = new MenuItem("Tomato Soup", new Money("24.45", Currency.SGD), FoodCategory.SOUP);
    public static final MenuItem seaMenuItemSalad = new MenuItem("SeaFood Salad", new Money("12.00", Currency.SGD));
    public static final MenuItem iceCream = new MenuItem("Chocolate Ice Cream", new Money("4.00", Currency.SGD));

    @Test
    void testSuggestShouldReturnDesiredCouponWhenAddSoup() throws BasketQuantityExceedException {
        Coupon coupon = new Coupon("DELIVERICIOUS_10", new BigDecimal("10"));
        Coupon coupon2 = new Coupon("DELIVERICIOUS_12", new BigDecimal("10"));
        Coupon coupon3 = new Coupon("DELIVERICIOUS_13", new BigDecimal("10"));
        Coupon coupon4 = new Coupon("DELIVERICIOUS_14", new BigDecimal("10"));
        CouponRepository couponRepository = new CouponRepository();
        couponRepository.addAll(List.of(coupon, coupon2, coupon3, coupon4));
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(tomatoSoup, 6));

        CouponService couponService = new CouponService();
        List<Coupon> availableCoupons = couponRepository.getAllAvailable();

        List<Coupon> couponsSuggested = couponService.suggest(availableCoupons, basket);
        assertEquals(couponsSuggested.size(), 1);
        assertEquals(couponsSuggested, List.of(coupon));
    }

    @Test
    void testisEligibleForSoupPromotion() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        basket.addBasketItem(new BasketItem(tomatoSoup, 6));
        CouponService couponService = new CouponService();
        assertTrue(couponService.isEligibleForSoupPromotion(basket));
    }
}