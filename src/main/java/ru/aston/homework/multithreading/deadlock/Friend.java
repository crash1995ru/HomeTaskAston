package ru.aston.homework.multithreading.deadlock;

public class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend bower) {
        System.out.println(this.name + ": " + bower.getName() + " bow to me!");
        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
        System.out.println(this.name + ": " + bower.getName() + " bow back to me!");
    }
}