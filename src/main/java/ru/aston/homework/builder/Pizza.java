package ru.aston.homework.builder;

import java.util.Objects;

public class Pizza {
    private final Size size;
    private final Dough dough;
    private final boolean cheese;
    private final boolean bacon;
    private final boolean mushrooms;
    private final String sauce;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.dough = builder.dough;
        this.cheese = builder.cheese;
        this.bacon = builder.bacon;
        this.mushrooms = builder.mushrooms;
        this.sauce = builder.sauce;
    }

    public static Builder builder(Size size, Dough dough) {
        return new Builder(size, dough);
    }

    @Override
    public String toString() {
        return String.format(
                "Пицца [%s, %s, соус: %s, сыр: %s, бекон: %s, грибы: %s]",
                size.getDisplayName(),
                dough.getDisplayName(),
                sauce,
                cheese ? "да" : "нет",
                bacon ? "да" : "нет",
                mushrooms ? "да" : "нет"
        );
    }

    public static class Builder {
        private final Size size;
        private final Dough dough;

        private boolean cheese;
        private boolean bacon;
        private boolean mushrooms;
        private String sauce = "томатный";

        private Builder(Size size, Dough dough) {
            this.size = size;
            this.dough = dough;
        }

        public Builder withCheese() {
            this.cheese = true;
            return this;
        }

        public Builder withBacon() {
            this.bacon = true;
            return this;
        }

        public Builder withMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Builder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Pizza build() {
            // Валидация перед созданием объекта
            if (size == null) {
                throw new IllegalStateException("Размер пиццы не может быть null");
            }
            if (dough == null) {
                throw new IllegalStateException("Тесто не может быть null");
            }
            if (sauce == null || sauce.isBlank()) {
                throw new IllegalStateException("Соус не может быть пустым или null");
            }

            return new Pizza(this);
        }
    }
}