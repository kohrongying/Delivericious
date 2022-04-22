package foodordering;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {
    public static final Money ZERO = new Money(BigDecimal.ZERO, Currency.SGD);
    private final BigDecimal amount;
    private final Currency currency;

    public Money(String amountInString, Currency currency) {
        this.amount = new BigDecimal(amountInString);
        this.currency = currency;
    }

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money multiply(BigDecimal bigDecimal) {
        return new Money(this.amount.multiply(bigDecimal), this.currency);
    }

    public static Money add(Money money, Money money1) {
        return new Money(money.amount.add(money1.amount), money.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return Objects.equals(currency, that.currency) && Objects.equals(amount, that.amount);
    }
}
