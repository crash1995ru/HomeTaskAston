package ru.aston.homework.strategy;

public class PercentDiscount implements DiscountStrategy {
    private final double percent;

    public PercentDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Процент должен быть от 0 до 100");
        }
        this.percent = percent;
    }

    @Override
    public double apply(double originalAmount) {
        return originalAmount * (1.0 - percent / 100.0);
    }

    @Override
    public String getName() {
        return "Скидка " + percent + "%";
    }
}