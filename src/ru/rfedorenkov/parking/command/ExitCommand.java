package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.ParkingSimulator;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Программа " + ParkingSimulator.PROGRAM_NAME + " завершена.");
        System.exit(0);
    }
}
