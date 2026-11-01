package ru.aston.homework.multithreading.livelock;

public class CommonResource {
    private Worker owner;

    public CommonResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker worker) {
        this.owner = worker;
    }
}