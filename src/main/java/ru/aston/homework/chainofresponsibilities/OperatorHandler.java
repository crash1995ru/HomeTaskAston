package ru.aston.homework.chainofresponsibilities;

public class OperatorHandler extends SupportHandler {
    @Override
    public boolean handleRequest(String issue, Severity severity) {
        if (severity == Severity.MEDIUM) {
            System.out.println("[Оператор] Решил: " + issue + " (Оформил возврат средств)");
            return true;
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(issue, severity);
        }
        return false;
    }
}
