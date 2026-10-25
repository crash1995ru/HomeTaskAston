package ru.aston.homework.chainofresponsibilities;

public class BotHandler extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity == 1) {
            System.out.println("[Бот] Автоматически решил: " + issue + " (Ответ: перезагрузите роутер)");
        } else if (nextHandler != null) {
            System.out.println("[Бот] Уровень 1 не подходит. Передаю дальше...");
            nextHandler.handleRequest(issue, severity);
        }
    }
}
