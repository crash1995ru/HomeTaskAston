package ru.aston.homework.chainofresponsibilities;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean handleRequest(String issue, Severity severity);
}