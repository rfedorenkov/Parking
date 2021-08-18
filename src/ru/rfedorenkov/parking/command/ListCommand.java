package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.entities.Car;
import ru.rfedorenkov.parking.entities.Parking;

public class ListCommand implements Command {
    @Override
    public void execute() {
        System.out.printf("Сейчас на парковке %d автомобилей:\n", Parking.getParking().size());
        if (!Parking.getParking().isEmpty()) {
            int parkingSpaceNumber = 1;
            for (Car car : Parking.getParking()) {
                System.out.printf("#%d | %s | № билета: %d\n", parkingSpaceNumber, car, car.getTicket().getId());
                parkingSpaceNumber++;
            }
        }
    }
}
