package ru.aston.homework.decorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", мокка";
    }

    @Override
    public double cost() {
        return beverage.cost() + 60.0;
    }
}

