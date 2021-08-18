package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.ParkManager;
import ru.rfedorenkov.parking.exception.WrongTicketNumberException;

public class LeaveSomeParkCommand implements Command {
    @Override
    public void execute() {
        try {
            ParkManager.leaveSomeParking();
        } catch (WrongTicketNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
