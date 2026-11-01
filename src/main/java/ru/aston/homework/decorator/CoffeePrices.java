package ru.aston.homework.decorator;

import java.math.BigDecimal;

public final class CoffeePrices {
    public static final BigDecimal ESPRESSO_BASE = new BigDecimal("150.00");
    public static final BigDecimal DARK_ROAST_BASE = new BigDecimal("120.00");
    public static final BigDecimal MILK_COST = new BigDecimal("40.00");
    public static final BigDecimal MOCHA_COST = new BigDecimal("60.00");
    public static final BigDecimal WHIP_COST = new BigDecimal("50.00");

    private CoffeePrices() {}
}