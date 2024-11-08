package com.yearup;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.yearup.util.Util.*;

public class NewOrderScreen {
    Order order;
    public NewOrderScreen() {
        order = new Order(UUID.randomUUID().toString(), LocalDateTime.now());
    }


    public void displayEntries() {
        for (Item item : order.getItems()) {
            if (item instanceof Sandwich) {
                System.out.println(CYAN + "  - " + item + RESET);
            } else if (item instanceof Drink) {
                System.out.println(CYAN + "  - " + item + RESET);
            } else if (item instanceof Chip) {
                System.out.println(CYAN + "  - " + item + RESET);
            }
        }
    }


    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            String newOrderOption = (String) promptUser(
                    "******************************\n" +
                            "New Order\n" +
                            "1 - Add Sandwich\n" +
                            "2 - Add Drink\n" +
                            "3 - Add Chips\n" +
                            "4 - Checkout\n" +
                            "0 - Cancel Order\n" , "string", false);

            switch (Integer.parseInt(newOrderOption)) {
                case 1:
                    processAddSandwichRequest();
                    break;
                case 2:
                    processAddDrinkRequest();
                    break;
                case 3:
                    processAddChipsRequest();
                    break;
                case 4:
                    processCheckoutRequest();
                    break;
                case 0:
                    System.out.println(CYAN + "You canceled the order" + RESET);
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
    }

    private void processCheckoutRequest() {
    }

    private void processAddChipsRequest() {
    }

    private void processAddDrinkRequest() {
    }

    private void processAddSandwichRequest() {
    }


}
