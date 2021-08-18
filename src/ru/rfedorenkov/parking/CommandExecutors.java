package ru.rfedorenkov.parking;

import ru.rfedorenkov.parking.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutors {
    private static final Map<Operation, Command> ALL_COMMANDS_MAP = new HashMap<>();

    static {
        ALL_COMMANDS_MAP.put(Operation.PARK, new ParkCommand());
        ALL_COMMANDS_MAP.put(Operation.LEAVE, new LeaveParkCommand());
        ALL_COMMANDS_MAP.put(Operation.LEAVE_SOME, new LeaveSomeParkCommand());
        ALL_COMMANDS_MAP.put(Operation.LIST, new ListCommand());
        ALL_COMMANDS_MAP.put(Operation.COUNT, new CountCommand());
        ALL_COMMANDS_MAP.put(Operation.TIME, new TimeCommand());
        ALL_COMMANDS_MAP.put(Operation.HELP, new HelpCommand());
        ALL_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutors() {
    }

    public static void execute(Operation operation) {
        ALL_COMMANDS_MAP.get(operation).execute();
    }
}