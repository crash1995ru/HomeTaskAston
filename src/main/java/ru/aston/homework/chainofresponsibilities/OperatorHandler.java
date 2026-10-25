package ru.aston.homework.chainofresponsibilities;

public class OperatorHandler extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity == 2) {
            System.out.println("[Оператор] Решил: " + issue + " (Оформил возврат средств)");
        } else if (nextHandler != null) {
            System.out.println("[Оператор] Слишком сложно. Передаю инженеру...");
            nextHandler.handleRequest(issue, severity);
        }
    }
}
