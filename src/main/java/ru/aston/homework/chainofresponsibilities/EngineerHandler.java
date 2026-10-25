package ru.aston.homework.chainofresponsibilities;

public class EngineerHandler extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity == 3) {
            System.out.println("[Инженер] Решил: " + issue + " (Перезагрузил сервер БД)");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("[Инженер] Проблема не решена. Никто не знает, что с этим делать.");
        }
    }
}