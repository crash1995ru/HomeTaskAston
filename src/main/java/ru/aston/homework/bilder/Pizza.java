package ru.aston.homework.bilder;

public class Pizza {
    private final String size;
    private final String dough;
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

    @Override
    public String toString() {
        return String.format("Пицца [%s, %s, соус: %s, сыр: %s, бекон: %s, грибы: %s]", size, dough, sauce, cheese ? "да" : "нет", bacon ? "да" : "нет", mushrooms ? "да" : "нет");
    }

    public static class Builder {
        private final String size;
        private final String dough;

        private boolean cheese = false;
        private boolean bacon = false;
        private boolean mushrooms = false;
        private String sauce = "томатный";

        public Builder(String size, String dough) {
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
            return new Pizza(this);
        }
    }
}