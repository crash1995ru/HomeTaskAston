package ru.aston.homework.chainofresponsibilities;

public class Main {
    public static void main(String[] args) {
        SupportHandler bot = new BotHandler();
        SupportHandler operator = new OperatorHandler();
        SupportHandler engineer = new EngineerHandler();

        bot.setNextHandler(operator);
        operator.setNextHandler(engineer);

        boolean resolved1 = bot.handleRequest("Не работает Wi-Fi", Severity.LOW);
        System.out.println("Решено: " + resolved1 + "\n");

        boolean resolved2 = bot.handleRequest("Списали деньги дважды", Severity.MEDIUM);
        System.out.println("Решено: " + resolved2 + "\n");

        boolean resolved3 = bot.handleRequest("Сервер упал", Severity.HIGH);
        System.out.println("Решено: " + resolved3);
    }
}