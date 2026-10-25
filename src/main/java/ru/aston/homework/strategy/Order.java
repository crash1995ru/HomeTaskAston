package ru.aston.homework.strategy;

public class Order {
    private final String orderId;
    private final double originalAmount;
    private DiscountStrategy discountStrategy;

    public Order(String orderId, double originalAmount) {
        this.orderId = orderId;
        this.originalAmount = originalAmount;
        this.discountStrategy = new NoDiscount();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void printReceipt() {
        double finalAmount = discountStrategy.apply(originalAmount);

        System.out.printf("=== Заказ %s ===%n", orderId);
        System.out.printf("Исходная сумма: %.2f руб.%n", originalAmount);
        System.out.printf("Применена:      %s%n", discountStrategy.getName());
        System.out.printf("Итого к оплате: %.2f руб.%n", finalAmount);
        System.out.println("-------------------------");
    }
}