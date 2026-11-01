package ru.aston.homework.bilder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza.Builder("Большая", "Тонкое")
                .withCheese()
                .build();

        Pizza pizza2 = new Pizza.Builder("Средняя", "Пышное")
                .withCheese()
                .withBacon()
                .withMushrooms()
                .withSauce("Барбекю")
                .build();

        Pizza pizza3 = new Pizza.Builder("Маленькая", "Тонкое")
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);
    }
}