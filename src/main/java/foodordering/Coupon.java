package foodordering;

import java.math.BigDecimal;
import java.util.UUID;

public class Coupon {
    private final UUID id = UUID.randomUUID();
    private final BigDecimal discountPercentage;
    private final String code;
    private boolean isAvailable;

    public Coupon(String code, BigDecimal discountPercentage) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.isAvailable = true;
    }

    public UUID id() {
        return this.id;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public String code() {
        return this.code;
    }
}
