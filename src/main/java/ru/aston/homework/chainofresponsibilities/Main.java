package ru.aston.homework.chainofresponsibilities;

public class Main {
    public static void main(String[] args) {

        SupportHandler bot = new BotHandler();
        SupportHandler operator = new OperatorHandler();
        SupportHandler engineer = new EngineerHandler();

        bot.setNextHandler(operator);
        operator.setNextHandler(engineer);

        System.out.println("--- Тест 1: Легкий вопрос ---");
        bot.handleRequest("Не работает Wi-Fi", 1);

        System.out.println("\n--- Тест 2: Проблема с оплатой ---");
        bot.handleRequest("Списали деньги дважды", 2);

        System.out.println("\n--- Тест 3: Сложный сбой ---");
        bot.handleRequest("Сервер упал, база данных не отвечает", 3);

        System.out.println("\n--- Тест 4: Неизвестный уровень (4) ---");
        bot.handleRequest("Проблема уровня 4", 4);
    }
}