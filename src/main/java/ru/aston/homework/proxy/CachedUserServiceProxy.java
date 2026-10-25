package ru.aston.homework.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachedUserServiceProxy implements UserService {
    private final UserService realService;
    private final Map<Integer, String> cache = new HashMap<>();

    private int cacheHits = 0;
    private int cacheMisses = 0;

    public CachedUserServiceProxy(UserService realService) {
        this.realService = realService;
    }

    @Override
    public String getUserName(int id) {
        // 1. Проверяем кэш
        if (cache.containsKey(id)) {
            System.out.println("<<< [PROXY] Кэш найден для ID: " + id + ". Возвращаем мгновенно.");
            cacheHits++;
            return cache.get(id);
        }

        // 2. Если в кэше нет — идем в реальную БД
        System.out.println("--- [PROXY] Кэш пуст для ID: " + id + ". Делегируем запрос в БД.");
        cacheMisses++;

        // Делегирование вызова
        String result = realService.getUserName(id);

        // 3. Сохраняем в кэш для будущих запросов
        cache.put(id, result);
        System.out.println("--- [PROXY] Результат сохранен в кэш для ID: " + id);

        return result;
    }

    public void printStats() {
        System.out.println("\n📊 Статистика кэша:");
        System.out.println("Попаданий (Hits): " + cacheHits);
        System.out.println("Промахов (Misses): " + cacheMisses);
    }
}