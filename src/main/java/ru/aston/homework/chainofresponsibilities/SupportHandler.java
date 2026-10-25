package ru.aston.homework.chainofresponsibilities;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    // Метод для выстраивания цепочки
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Главный метод обработки
    public abstract void handleRequest(String issue, int severity);
}
