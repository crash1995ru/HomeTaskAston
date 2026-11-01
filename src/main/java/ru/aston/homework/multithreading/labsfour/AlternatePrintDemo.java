package ru.aston.homework.multithreading.labsfour;

public class AlternatePrintDemo {
    public static void main(String[] args) {
        final AlternatePrinter printer = new AlternatePrinter();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                printer.printFirst();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                printer.printSecond();
            }
        });

        // фоновые потоки, чтобы JVM завершилась после main
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nГотово");
    }
}