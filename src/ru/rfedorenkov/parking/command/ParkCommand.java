package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.ParkManager;
import ru.rfedorenkov.parking.exception.NoParkingSpacesException;

public class ParkCommand implements Command {

    @Override
    public void execute() {
        try {
            ParkManager.parking();
        } catch (NoParkingSpacesException e) {
            System.out.println(e.getMessage());
        }
    }
}