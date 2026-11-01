package ru.aston.homework.builder;

public enum Size {
    SMALL("Маленькая"),
    MEDIUM("Средняя"),
    LARGE("Большая");

    private final String displayName;

    Size(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}