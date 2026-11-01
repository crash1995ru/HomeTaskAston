package ru.aston.homework.decorator;

import java.math.BigDecimal;

public interface Beverage {
    String getDescription();
    BigDecimal cost();
}

class Espresso implements Beverage {
    @Override
    public String getDescription() { return "Эспрессо"; }

    @Override
    public BigDecimal cost() { return CoffeePrices.ESPRESSO_BASE; }
}

class DarkRoast implements Beverage {
    @Override
    public String getDescription() { return "Тёмная обжарка"; }

    @Override
    public BigDecimal cost() { return CoffeePrices.DARK_ROAST_BASE; }
}