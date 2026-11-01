package ru.aston.homework.decorator;

import java.math.BigDecimal;

public abstract class CondimentDecorator implements Beverage {
    protected final Beverage beverage;

    protected CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) { super(beverage); }

    @Override
    public String getDescription() { return beverage.getDescription() + ", молоко"; }

    @Override
    public BigDecimal cost() { return beverage.cost().add(CoffeePrices.MILK_COST); }
}

class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) { super(beverage); }

    @Override
    public String getDescription() { return beverage.getDescription() + ", мокка"; }

    @Override
    public BigDecimal cost() { return beverage.cost().add(CoffeePrices.MOCHA_COST); }
}

class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) { super(beverage); }

    @Override
    public String getDescription() { return beverage.getDescription() + ", сливки"; }

    @Override
    public BigDecimal cost() { return beverage.cost().add(CoffeePrices.WHIP_COST); }
}