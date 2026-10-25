package ru.aston.homework.strategy;

public interface DiscountStrategy {

    double apply(double originalAmount);
    String getName();
}