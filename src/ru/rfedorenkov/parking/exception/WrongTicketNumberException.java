package ru.rfedorenkov.parking.exception;

public class WrongTicketNumberException extends Exception {
    public WrongTicketNumberException(String message) {
        super(message);
    }
}
