package ru.rfedorenkov.parking;

import ru.rfedorenkov.parking.entities.Car;
import ru.rfedorenkov.parking.entities.Parking;
import ru.rfedorenkov.parking.exception.IncorrectNumberException;
import ru.rfedorenkov.parking.exception.NoParkingSpacesException;
import ru.rfedorenkov.parking.exception.WrongTicketNumberException;

import java.util.Arrays;

public class ParkManager {
    private static String command;

    private ParkManager() {
    }

    public static void setCommand(String command) {
        ParkManager.command = command;
    }

    public static void parking() throws NoParkingSpacesException {
        int totalCars = Integer.parseInt(command.split(":")[1]);
        if (Parking.getTickets().size() >= totalCars) {
            for (int i = 0; i < totalCars; i++) {
                new Thread(new Car()).start();
            }
        } else {
            throw new NoParkingSpacesException("На парковке не достаточно свободных мест!");
        }
    }

    public static void leaveParking() throws WrongTicketNumberException {
        int[] ticketsNumbers = new int[]{Integer.parseInt(command.split(":")[1])};
        removeCars(ticketsNumbers);
    }

    public static void leaveSomeParking() throws WrongTicketNumberException {
        int[] ticketsNumbers = Arrays.
                stream(command.split("u:")[1].substring(1, command.split("u:")[1].length() - 1).split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        removeCars(ticketsNumbers);

    }

    private static void removeCars(int... ticketNumbers) throws WrongTicketNumberException {
        for (int ticketNumber : ticketNumbers) {
            removeCar(ticketNumber);
        }
    }

    private static void removeCar(int ticketNumber) throws WrongTicketNumberException {
        boolean isFounded = false;

        for (Car car : Parking.getParking()) {
            if (car.getTicket().getId() == ticketNumber) {
                new Thread(car).start();
                isFounded = true;
            }
        }

        if (!isFounded) {
            throw new WrongTicketNumberException("Не припаркована машина с билетом №" + ticketNumber);
        }
    }

    public static void setTime() throws IncorrectNumberException {
        int seconds = Integer.parseInt(command.split(":")[1]);
        if (seconds >= 1 && seconds <= 5) {
            Car.setDelay(seconds);
            System.out.println("Время въезда/выезда установлено на " + seconds + " секунд");
        } else {
            throw new IncorrectNumberException("Ошибка. Значение может быть только от 1 до 5! Возврат в меню.");
        }
    }
}
