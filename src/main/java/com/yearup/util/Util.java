package com.yearup.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Util {
    static Scanner scanner = new Scanner(System.in);

    // color for the console
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static Object promptUser(String message, String type, boolean isOptional) {
        String input;
        while (true) {
            System.out.print(CYAN + message + RESET);
            input = scanner.nextLine().trim();

            if (!isOptional && input.isEmpty()) {
                System.out.println(RED + "Input cannot be empty. Please try again." + RESET);
                continue;
            }

            switch (type.toLowerCase()) {
                case "string":
                    return input;

                case "double":
                    Double doubleValue = parseDouble(input);
                    if (doubleValue != null && doubleValue >= 0) {
                        return doubleValue;
                    } else if (doubleValue == null) {
                        System.out.println(RED + "Invalid number format. Please enter a valid amount." + RESET);
                    } else {
                        System.out.println(RED + "Amount must be greater than zero." + RESET);
                    }
                    break;

                case "int":
                    Integer intValue = parseInt(input);
                    if (intValue != null) {
                        return intValue;
                    } else {
                        System.out.println(RED + "Invalid number format. Please enter a valid integer." + RESET);
                    }
                    break;

                case "date":
                    LocalDate date = parseDate(input);
                    if (date != null && !date.isAfter(LocalDate.now())) {
                        return date;
                    } else if (date == null) {
                        System.out.println(RED + "Invalid date format. Please use YYYY-MM-DD." + RESET);
                    } else {
                        System.out.println(RED + "The date cannot be in the future." + RESET);
                    }
                    break;

                default:
                    System.out.println(RED + "Invalid input type." + RESET);
            }
        }
    }

    private static Double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
