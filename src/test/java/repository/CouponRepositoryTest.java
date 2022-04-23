package repository;

import foodordering.Coupon;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CouponRepositoryTest {
    @Test
    void setAndgetAllAvailable() {
        CouponRepository couponRepository = new CouponRepository();
        Coupon coupon = new Coupon("DELIVERICIOUS_10", new BigDecimal("10"));
        Coupon coupon2 = new Coupon("DELIVERICIOUS_20", new BigDecimal("10"));
        couponRepository.addAll(List.of(coupon, coupon2));

        List<Coupon> allCoupons = couponRepository.getAllAvailable();

        assertEquals(allCoupons.size(), 2);
        assertTrue(allCoupons.contains(coupon));
        assertTrue(allCoupons.contains(coupon2));
    }
}