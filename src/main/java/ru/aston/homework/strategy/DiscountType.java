package ru.aston.homework.strategy;

import java.math.BigDecimal;
import java.util.Map;

public enum DiscountType {
    NONE, PERCENT_10, FIXED_500
}

class DiscountFactory {
    private static final Map<DiscountType, DiscountStrategy> STRATEGIES = Map.of(
            DiscountType.NONE, new NoDiscount(),
            DiscountType.PERCENT_10, new PercentDiscount(new BigDecimal("10")),
            DiscountType.FIXED_500, new FixedAmountDiscount(new BigDecimal("500"))
    );

    public static DiscountStrategy getStrategy(DiscountType type) {
        return STRATEGIES.get(type);
    }
}