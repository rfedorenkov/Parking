package ru.rfedorenkov.parking.entities;

import java.util.Random;

public class LicensePlate {

    private final static String[] REGION = {
            "01", "02,", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
            "71", "72", "73", "74", "75", "76", "77", "78", "69", "70",
            "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
            "95", "98", "99"
    };

    private final static String[] LETTERS = {
            "A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"
    };

    private LicensePlate() {
    }

    public static String getLicensePlate() {
        return getRandomLetter() + getRandomNumber() + getRandomLetter() + getRandomLetter() + getRandomRegion();
    }

    private static String getRandomLetter() {
        return LETTERS[(int) (Math.random() * LETTERS.length)];
    }

    private static String getRandomNumber() {
        return String.format("%03d", new Random().nextInt(1000));
    }

    private static String getRandomRegion() {
        return REGION[(int) (Math.random() * REGION.length)];
    }
}
