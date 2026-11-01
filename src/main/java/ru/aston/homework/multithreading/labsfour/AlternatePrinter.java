package ru.aston.homework.multithreading.labsfour;

public class AlternatePrinter {
    private final Object lock = new Object();
    private boolean firstTurn = true; // true = печатает поток 1

    public void printFirst() {
        while (true) {
            synchronized (lock) {
                while (!firstTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("1");
                firstTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void printSecond() {
        while (true) {
            synchronized (lock) {
                while (firstTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("2");
                firstTurn = true;
                lock.notifyAll();
            }
        }
    }
}