package ru.aston.homework.strategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double apply(double originalAmount) {
        return originalAmount;
    }

    @Override
    public String getName() {
        return "Без скидки";
    }
}