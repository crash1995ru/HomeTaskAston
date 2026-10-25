package ru.aston.homework.adapter;

class PowerAdapter implements UsbC {
    private final EuSocket socket;

    public PowerAdapter(EuSocket socket) {
        this.socket = socket;
    }

    @Override
    public void chargeWithUsbC() {
        System.out.print("Адаптер преобразует 220V -> 5V. ");
        socket.provide220V();
        System.out.println("Телефон заряжается.");
    }
}