package ru.aston.homework.decorator;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", молоко";
    }

    @Override
    public double cost() {
        return beverage.cost() + 40.0;
    }
}


