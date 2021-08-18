package ru.rfedorenkov.parking;

import ru.rfedorenkov.parking.entities.Parking;
import ru.rfedorenkov.parking.entities.Ticket;

import java.util.Scanner;

public class ParkingSimulator {
    public static final String PROGRAM_NAME = "Parking Simulator";

    private final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        new ParkingSimulator().start();
    }

    private void start() {
        welcome();

        Operation operation;
        do {
            operation = askOperation();
            CommandExecutors.execute(operation);
        } while (operation != Operation.EXIT);

    }

    private void welcome() {
        System.out.print("Добро пожаловать в " + PROGRAM_NAME + "!\n" +
                "Введите кол-во парковочных мест: ");
        while (true) {
            try {
                int numberOfParkingSpaces = Integer.parseInt(console.nextLine());
                if (numberOfParkingSpaces > 0) {
                    createParking(numberOfParkingSpaces);
                    break;
                } else {
                    System.out.println("Количество парковочных мест должно быть больше нуля!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое неотрицательное число больше нуля!");
            }
        }
    }

    private void createParking(int numberOfParkingSpaces) {
        Parking.setTotalSpace(numberOfParkingSpaces);
        for (int i = 1; i <= numberOfParkingSpaces; i++) {
            Parking.getTickets().add(new Ticket(i));
        }
    }

    private Operation askOperation() {
        System.out.println("Введите команду (help для списка команд):");
        String text = console.nextLine().toLowerCase();

        if (text.equals("exit") || text.equals("e")) {
            return Operation.EXIT;
        }

        if (text.equals("help") || text.equals("h")) {
            return Operation.HELP;
        }

        if (text.startsWith("p:")) {
            ParkManager.setCommand(text);
            return Operation.PARK;
        }

        if (text.startsWith("u:[")) {
            ParkManager.setCommand(text);
            return Operation.LEAVE_SOME;
        }

        if (text.startsWith("u:")) {
            ParkManager.setCommand(text);
            return Operation.LEAVE;
        }

        if (text.equals("l") || text.equals("list")) {
            return Operation.LIST;
        }

        if (text.equals("c") || text.equals("count")) {
            ParkManager.setCommand(text);
            return Operation.COUNT;
        }

        if (text.startsWith("t:")) {
            ParkManager.setCommand(text);
            return Operation.TIME;
        }

        System.out.println("Неопознанная команда. Попробуйте ещё раз.");
        return askOperation();
    }
}
