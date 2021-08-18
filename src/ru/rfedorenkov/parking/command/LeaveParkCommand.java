package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.ParkManager;
import ru.rfedorenkov.parking.exception.WrongTicketNumberException;

public class LeaveParkCommand implements Command {
    @Override
    public void execute() {
        try {
            ParkManager.leaveParking();
        } catch (WrongTicketNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}


