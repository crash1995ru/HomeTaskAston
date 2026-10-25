package ru.aston.homework.proxy;

public class Main {
    public static void main(String[] args) {

        UserService realService = new RealUserService();
        CachedUserServiceProxy proxy = new CachedUserServiceProxy(realService);
        System.out.println("--- Первый запрос (ожидаем 1.5 сек) ---");
        long start1 = System.currentTimeMillis();
        System.out.println("Получено: " + proxy.getUserName(1));
        System.out.println("Время: " + (System.currentTimeMillis() - start1) + " мс\n");
        System.out.println("--- Второй запрос того же ID (ожидаем 0 мс) ---");
        long start2 = System.currentTimeMillis();
        System.out.println("Получено: " + proxy.getUserName(1));
        System.out.println("Время: " + (System.currentTimeMillis() - start2) + " мс\n");
        System.out.println("--- Запрос другого ID (ожидаем 1.5 сек) ---");
        long start3 = System.currentTimeMillis();
        System.out.println("Получено: " + proxy.getUserName(2));
        System.out.println("Время: " + (System.currentTimeMillis() - start3) + " мс\n");

        proxy.printStats();
    }
}
