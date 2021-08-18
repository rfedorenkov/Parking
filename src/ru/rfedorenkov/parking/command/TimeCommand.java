package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.ParkManager;
import ru.rfedorenkov.parking.exception.IncorrectNumberException;

public class TimeCommand implements Command {
    @Override
    public void execute() {
        try {
            ParkManager.setTime();
        } catch (IncorrectNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
