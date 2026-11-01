package ru.aston.homework.adapter;

public class WallSocket implements EuSocket {
    @Override
    public int provideVoltage() {
        return 220;
    }
}