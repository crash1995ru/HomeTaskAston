package ru.aston.homework.adapter;

public class Phone {
    public void charge(UsbC charger) {
        int voltage = charger.getVoltage();
        if (voltage == 5) {
            System.out.println("Телефон заряжается (5V)");
        } else {
            System.out.println("Ошибка: неподходящее напряжение " + voltage + "V");
        }
    }
}