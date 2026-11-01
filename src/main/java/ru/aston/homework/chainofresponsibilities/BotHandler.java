package ru.aston.homework.chainofresponsibilities;

public class BotHandler extends SupportHandler {
    @Override
    public boolean handleRequest(String issue, Severity severity) {
        if (severity == Severity.LOW) {
            System.out.println("[Бот] Автоматически решил: " + issue + " (Ответ: перезагрузите роутер)");
            return true;
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(issue, severity);
        }
        return false;
    }
}