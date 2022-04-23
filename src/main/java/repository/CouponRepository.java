package repository;

import foodordering.Coupon;

import java.util.*;
import java.util.stream.Collectors;

public class CouponRepository {
    private final HashMap<UUID, Coupon> coupons = new HashMap<>();

    public void add (Coupon coupon) {
        this.coupons.put(coupon.id(), coupon);
    }

    public void addAll(List<Coupon> coupons) {
        for (Coupon coupon : coupons) {
            this.add(coupon);
        }
    }

    public List<Coupon> getAllAvailable() {
        List<Coupon> couponValues = new ArrayList<>(coupons.values());
        return couponValues.stream()
                .filter(Coupon::isAvailable)
                .collect(Collectors.toList());
    }
}
