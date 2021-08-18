package ru.rfedorenkov.parking.command;

import ru.rfedorenkov.parking.Operation;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Доступные команды:");
        for (Operation operation : Operation.values()) {
            System.out.println(operation.getInfo());
        }
    }
}
