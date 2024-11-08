package com.yearup;

import static com.yearup.util.Util.*;

public class HomeScreen {

    public HomeScreen() {
    }

    private void init() {
    }


    public void display() {
        init();
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

    private void processNewOrderRequest() {
        NewOrderScreen newOrderScreen = new NewOrderScreen();
        newOrderScreen.displayEntries();
        newOrderScreen.displayMenu();
    }


}
