package ru.aston.homework.multithreading.livelock;

public class LivelockDemo {
    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);
        final CommonResource resource = new CommonResource(worker1);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                worker1.work(resource, worker2);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                worker2.work(resource, worker1);
            }
        });

        t1.start();
        t2.start();
    }
}