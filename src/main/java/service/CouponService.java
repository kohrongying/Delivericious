package service;

import foodordering.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CouponService {

    public List<Coupon> suggest(List<Coupon> availableCoupons, Basket basket) {
        List<Coupon> eligibleCoupons = new ArrayList<>();
        if (this.isEligibleForSoupPromotion(basket)) {
            Optional<Coupon> soupCoupon = availableCoupons.stream()
                    .filter(coupon -> coupon.code().equals("DELIVERICIOUS_10"))
                    .findFirst();
            soupCoupon.ifPresent(eligibleCoupons::add);
        }
        return eligibleCoupons;
    }

    public boolean isEligibleForSoupPromotion(Basket basket) {
        Integer totalSoupQuantity = basket.getBasketItemByCategory(FoodCategory.SOUP)
                .stream()
                .map(BasketItem::quantity)
                .reduce(0, Integer::sum);
        return totalSoupQuantity >= 5;
    }
}
