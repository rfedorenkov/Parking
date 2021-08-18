package ru.rfedorenkov.parking.entities;

import java.util.*;

public class Parking {
    private static final Set<Car> PARKING = new HashSet<>();
    private static final Queue<Ticket> TICKETS = new ArrayDeque<>();

    private static int totalSpace;

    private Parking() {
    }

    public static int getTotalSpace() {
        return totalSpace;
    }

    public static void setTotalSpace(int totalSpace) {
        Parking.totalSpace = totalSpace;
    }

    public static synchronized Set<Car> getParking() {
        return PARKING;
    }

    public static synchronized void enterParking(Car car) {
        Ticket ticket = TICKETS.poll();
        car.setTicket(ticket);
        PARKING.add(car);
    }

    public static synchronized void exitParking(Car car) {
        TICKETS.add(car.getTicket());
        car.setTicket(null);
        PARKING.remove(car);
    }

    public static boolean containsCar(Car car) {
        return PARKING.contains(car);
    }

    public static Queue<Ticket> getTickets() {
        return TICKETS;
    }

    public static int getFreeParkingSpaces() {
        return totalSpace - PARKING.size();
    }

}
