package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.entities.Parking;

public class CountCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Сободных мест на парковке: " + Parking.getFreeParkingSpaces());
    }
}

