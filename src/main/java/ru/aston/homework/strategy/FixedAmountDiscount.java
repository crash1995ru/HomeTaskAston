package ru.aston.homework.strategy;

public class FixedAmountDiscount implements DiscountStrategy {
    private final double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double apply(double originalAmount) {
        return Math.max(0, originalAmount - amount);
    }

    @Override
    public String getName() {
        return "Фиксированная скидка " + amount + " руб.";
    }
}