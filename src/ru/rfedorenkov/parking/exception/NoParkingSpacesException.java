package ru.rfedorenkov.parking.exception;

public class NoParkingSpacesException extends Exception {
    public NoParkingSpacesException(String message) {
        super(message);
    }
}
