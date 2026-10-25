package ru.aston.homework.decorator;

public class Main {
    public static void main(String[] args) {

        Beverage coffee1 = new Espresso();
        System.out.println(coffee1.getDescription() + " = " + coffee1.cost() + " руб.");

        Beverage coffee2 = new Espresso();
        coffee2 = new Milk(coffee2);
        System.out.println(coffee2.getDescription() + " = " + coffee2.cost() + " руб.");

        Beverage coffee3 = new DarkRoast();
        coffee3 = new Mocha(coffee3);
        coffee3 = new Mocha(coffee3);
        coffee3 = new Whip(coffee3);
        System.out.println(coffee3.getDescription() + " = " + coffee3.cost() + " руб.");

        Beverage coffee4 = new Whip(new Mocha(new Milk(new Espresso())));
        System.out.println(coffee4.getDescription() + " = " + coffee4.cost() + " руб.");
    }
}