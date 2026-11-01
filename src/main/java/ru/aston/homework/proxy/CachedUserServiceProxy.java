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
        if (cache.containsKey(id)) {
            System.out.println("[PROXY] Кэш найден для ID: " + id);
            cacheHits++;
            return cache.get(id);
        }

        System.out.println("[PROXY] Кэш пуст для ID: " + id + ". Запрос в БД.");
        cacheMisses++;
        String result = realService.getUserName(id);
        cache.put(id, result);
        return result;
    }

    public void printStats() {
        System.out.println("Статистика кэша: Hits=" + cacheHits + ", Misses=" + cacheMisses);
    }
}