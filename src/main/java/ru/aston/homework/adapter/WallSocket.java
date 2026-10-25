package ru.aston.homework.adapter;

class WallSocket implements EuSocket {
    public void provide220V() {
        System.out.println("Розетка выдает 220V...");
    }
}
