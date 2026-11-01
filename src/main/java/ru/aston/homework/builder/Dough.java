package ru.aston.homework.builder;

public enum Dough {
    THIN("Тонкое"),
    THICK("Пышное");

    private final String displayName;

    Dough(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}