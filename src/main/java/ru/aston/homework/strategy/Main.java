package ru.aston.homework.strategy;

import ru.aston.homework.decorator.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("ORD-101", new BigDecimal("1000.10"));

        order.setDiscountStrategy(DiscountFactory.getStrategy(DiscountType.PERCENT_10));
        ReceiptPrinter.print(order);

        Beverage coffee = new Whip(new Mocha(new Milk(new Espresso())));
        System.out.printf("%s = %.2f руб.%n", coffee.getDescription(), coffee.cost());
    }
}