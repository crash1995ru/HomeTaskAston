package ru.aston.homework.multithreading.livelock;

public class Worker {
    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(CommonResource resource, Worker otherWorker) {
        while (active) {
            // если ресурс не у нас — ждём немного и проверяем снова
            if (resource.getOwner() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            // ресурс у нас, но другой работник ещё активен — уступаем
            if (otherWorker.isActive()) {
                System.out.println(getName() + ": передаю ресурс работнику " + otherWorker.getName());
                resource.setOwner(otherWorker);
                continue;
            }

            // наконец работаем
            System.out.println(getName() + ": работаю с общим ресурсом");
            active = false;
            resource.setOwner(otherWorker);
        }
    }
}