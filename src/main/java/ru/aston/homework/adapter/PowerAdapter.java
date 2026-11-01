package ru.aston.homework.adapter;

public class PowerAdapter implements UsbC {
    private final EuSocket socket;

    public PowerAdapter(EuSocket socket) {
        this.socket = socket;
    }

    @Override
    public int getVoltage() {
        int inputVoltage = socket.provideVoltage();
        // Реальное преобразование: 220V -> 5V
        return inputVoltage == 220 ? 5 : 0;
    }
}