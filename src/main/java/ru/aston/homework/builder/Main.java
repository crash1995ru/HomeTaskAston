package ru.aston.homework.builder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = Pizza.builder(Size.LARGE, Dough.THIN)
                .withCheese()
                .build();

        Pizza pizza2 = Pizza.builder(Size.MEDIUM, Dough.THICK)
                .withCheese()
                .withBacon()
                .withMushrooms()
                .withSauce("Барбекю")
                .build();

        Pizza pizza3 = Pizza.builder(Size.SMALL, Dough.THIN)
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);

        // Проверка валидации
        try {
            Pizza.builder(null, Dough.THIN).build();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}