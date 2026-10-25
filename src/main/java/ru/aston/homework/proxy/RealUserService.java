package ru.aston.homework.proxy;

import java.util.Map;

public class RealUserService implements UserService {

    // Имитация базы данных
    private final Map<Integer, String> database = Map.of(
            1, "Иван Иванов",
            2, "Мария Петрова",
            3, "Алексей Смирнов"
    );

    @Override
    public String getUserName(int id) {
        System.out.println(" [DB] Идет запрос к базе данных для ID: " + id + "...");
        simulateNetworkDelay();

        String name = database.get(id);
        if (name == null) {
            throw new IllegalArgumentException("Пользователь с ID " + id + " не найден");
        }
        return name;
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}