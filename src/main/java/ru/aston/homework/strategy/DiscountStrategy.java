package ru.aston.homework.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface DiscountStrategy {
    BigDecimal apply(BigDecimal originalAmount);
    String getName();
}

class NoDiscount implements DiscountStrategy {
    @Override
    public BigDecimal apply(BigDecimal originalAmount) { return originalAmount; }

    @Override
    public String getName() { return "Без скидки"; }
}

class PercentDiscount implements DiscountStrategy {
    private static final BigDecimal HUNDRED = new BigDecimal("100");
    private final BigDecimal percent;

    public PercentDiscount(BigDecimal percent) {
        if (percent.compareTo(BigDecimal.ZERO) < 0 || percent.compareTo(HUNDRED) > 0) {
            throw new IllegalArgumentException("Процент должен быть от 0 до 100");
        }
        this.percent = percent;
    }

    @Override
    public BigDecimal apply(BigDecimal originalAmount) {
        // 1000.10 - (1000.10 * 33.3 / 100)
        BigDecimal discountAmount = originalAmount.multiply(percent).divide(HUNDRED, 2, RoundingMode.HALF_UP);
        return originalAmount.subtract(discountAmount);
    }

    @Override
    public String getName() { return "Скидка " + percent + "%"; }
}

class FixedAmountDiscount implements DiscountStrategy {
    private final BigDecimal amount;

    public FixedAmountDiscount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Сумма скидки не может быть отрицательной");
        }
        this.amount = amount;
    }

    @Override
    public BigDecimal apply(BigDecimal originalAmount) {
        BigDecimal result = originalAmount.subtract(amount);
        return result.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : result;
    }

    @Override
    public String getName() { return "Фиксированная скидка " + amount + " руб."; }
}