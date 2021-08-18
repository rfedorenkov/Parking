package ru.rfedorenkov.parking.entities;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static final Semaphore semaphore = new Semaphore(2);
    private static int delay = 500;

    private final String licensePlate;
    private Ticket ticket = null;
    private boolean isPark = false;

    public Car() {
        licensePlate = LicensePlate.getLicensePlate();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public static void setDelay(int delay) {
        Car.delay = delay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(licensePlate, car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }

    @Override
    public String toString() {
        return "автомобиль с номером " + licensePlate;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            if (!isPark) {
                enterParking();
            } else {
                leaveParking();
            }
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void sleep() {
        try {
            this.wait(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void enterParking() {
        System.out.println("Подъезжает " + this);
        sleep();
        Parking.enterParking(this);
        System.out.println("Въехал " + this + " | выдан билет №" + this.ticket);
        isPark = true;
        if (!Parking.containsCar(this)) {
            throw new RuntimeException("Ошибка: " + this + " не на парковке.");
        }

    }

    private synchronized void leaveParking() {
        System.out.println(this + " c билетом №" + this.ticket + " выезжает с парковки.");
        sleep();
        System.out.println(this + " c билетом №" + this.ticket + " уехал.");
        Parking.exitParking(this);
        isPark = false;
    }
}