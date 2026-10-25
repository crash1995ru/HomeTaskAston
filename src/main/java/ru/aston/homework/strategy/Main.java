package ru.aston.homework.strategy;

public class Main {
    public static void main(String[] args) {

        Order order = new Order("ORD-101", 2000.0);
        order.printReceipt();
        order.setDiscountStrategy(new PercentDiscount(10));
        order.printReceipt();
        order.setDiscountStrategy(new FixedAmountDiscount(500));
        order.printReceipt();
        try {
            order.setDiscountStrategy(new PercentDiscount(150));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}