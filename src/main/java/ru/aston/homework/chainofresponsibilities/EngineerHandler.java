package ru.aston.homework.chainofresponsibilities;

public class EngineerHandler extends SupportHandler {
    @Override
    public boolean handleRequest(String issue, Severity severity) {
        if (severity == Severity.HIGH) {
            System.out.println("[Инженер] Решил: " + issue + " (Перезагрузил сервер БД)");
            return true;
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(issue, severity);
        }
        return false;
    }
}