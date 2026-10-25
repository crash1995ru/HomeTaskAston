package ru.aston.homework.decorator;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", сливки";
    }

    @Override
    public double cost() {
        return beverage.cost() + 50.0;
    }
}