package ru.aston.homework.multithreading.deadlock;

public class DeadlockDemo {
    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        });

        t1.start();
        t2.start();
    }
}