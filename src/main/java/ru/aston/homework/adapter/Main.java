package ru.aston.homework.adapter;

public class Main {
    public static void main(String[] args) {
        EuSocket socket = new WallSocket();
        UsbC adapter = new PowerAdapter(socket);
        Phone phone = new Phone();

        phone.charge(adapter);
    }
}