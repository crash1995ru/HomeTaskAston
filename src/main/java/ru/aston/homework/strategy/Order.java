package ru.aston.homework.strategy;

import java.math.BigDecimal;

public class Order {
    private final String orderId;
    private final BigDecimal originalAmount;
    private DiscountStrategy discountStrategy;

    public Order(String orderId, BigDecimal originalAmount) {
        this.orderId = orderId;
        this.originalAmount = originalAmount;
        this.discountStrategy = new NoDiscount();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal getFinalAmount() {
        return discountStrategy.apply(originalAmount);
    }

    public String getOrderId() { return orderId; }
    public BigDecimal getOriginalAmount() { return originalAmount; }
    public DiscountStrategy getDiscountStrategy() { return discountStrategy; }
}