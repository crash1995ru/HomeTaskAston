package ru.aston.homework.decorator;

public abstract class CondimentDecorator implements Beverage {
    protected final Beverage beverage; // Ссылка на "обёрнутый" объект

    protected CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}