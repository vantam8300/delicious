package com.yearup;

import static com.yearup.util.Util.*;

public class HomeScreen {

    public HomeScreen() {
    }

    // display Home screen
    public void display() {
        boolean exit = false;
        while (!exit) {
            String homeOption = (String) promptUser(
                    "1 - New Order\n" +
                            "0 - Exit\n", "string", false);

            switch (Integer.parseInt(homeOption)) {
                case 1:
                    processNewOrderRequest();
                    break;

                case 0:
                    System.out.println(CYAN + "Thank you for using application" + RESET);
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
    }

    // initiate New Order Screen and display a New Order menu
    private void processNewOrderRequest() {
        NewOrderScreen newOrderScreen = new NewOrderScreen();
        newOrderScreen.displayMenu();
    }
}
