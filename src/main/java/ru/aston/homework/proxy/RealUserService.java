package ru.aston.homework.proxy;

import java.util.Map;

public class RealUserService implements UserService {
    private static final long NETWORK_DELAY_MS = 500; // Вынесли в константу
    private static final Map<Integer, String> DATABASE = Map.of(
            1, "Иван Иванов",
            2, "Мария Петрова",
            3, "Алексей Смирнов"
    );

    @Override
    public String getUserName(int id) {
        System.out.println("[DB] Запрос к базе данных для ID: " + id);
        try {
            Thread.sleep(NETWORK_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String name = DATABASE.get(id);
        if (name == null) {
            throw new IllegalArgumentException("Пользователь с ID " + id + " не найден");
        }
        return name;
    }
}