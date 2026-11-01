package ru.aston.homework.strategy;

public class ReceiptPrinter {
    public static void print(Order order) {
        System.out.printf("=== Заказ %s ===%n", order.getOrderId());
        System.out.printf("Исходная сумма: %.2f руб.%n", order.getOriginalAmount());
        System.out.printf("Применена:      %s%n", order.getDiscountStrategy().getName());
        System.out.printf("Итого к оплате: %.2f руб.%n", order.getFinalAmount());
        System.out.println("-------------------------");
    }
}