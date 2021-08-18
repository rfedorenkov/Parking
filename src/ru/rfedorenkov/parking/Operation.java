package ru.rfedorenkov.parking;

public enum Operation {


    PARK("p:N - (park) чтобы припарковать машину, в командной строке вводится," +
            "где N - количество машин на въезд"),

    LEAVE("u:N - (unpark) чтобы выехать с парковки. N - номер парковочного билета"),

    LEAVE_SOME("u:[1..n] - (unpark) чтобы выехать с парковки нескольким машинам," +
            "где в квадратных скобках, через запятую передаются номера парковочных билетов"),

    LIST("l - (list) список машин, находящихся на парковке." +
            "Для каждой машины выводится ее порядковый номер и номер билета"),

    COUNT("c - (count) количество оставшихся мест на парковке"),

    EXIT("e - (exit) выход из приложения"),

    TIME("t:N - (time) установить время для въезда и выезда одной машины (N - от 1 до 5 сек)"),

    HELP("h - (help) вызов списка команд");

    private final String info;

    Operation(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}