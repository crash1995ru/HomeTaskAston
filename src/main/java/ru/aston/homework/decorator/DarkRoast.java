package ru.aston.homework.decorator;

public class DarkRoast implements Beverage {
    @Override
    public String getDescription() {
        return "Тёмная обжарка";
    }

    @Override
    public double cost() {
        return 120.0;
    }
}
