package ru.aston.homework.decorator;

public class Espresso implements Beverage {
    @Override
    public String getDescription() {
        return "Эспрессо";
    }

    @Override
    public double cost() {
        return 150.0;
    }
}