package com.yearup;

import java.util.ArrayList;
import java.util.List;

import static com.yearup.util.Util.*;

public class AddToppingScreen {
    List<Topping> toppings;

    // Create List of toppings to store user input data
    public AddToppingScreen() {
        toppings = new ArrayList<>();
    }

    // prompt user for toppings option
    public void display() {
        boolean exit = false;
        while (!exit) {
            String AddToppingOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Select Meat      " + (toppings.stream().anyMatch(t -> t instanceof Meat) ? "✓\n" : "\n" ) +
                            "2 - Select Cheese      " + (toppings.stream().anyMatch(t -> t instanceof Cheese) ? "✓\n" : "\n" ) +
                            "3 - Select Other Toppings       " + (toppings.stream().anyMatch(t -> t instanceof OtherTopping) ? "✓\n" : "\n" ) +
                            "4 - Select Sauces       " + (toppings.stream().anyMatch(t -> t instanceof Sauce) ? "✓\n" : "\n" ) +
                            "5 - Complete\n" +
                            "0 - Go Back\n" , "string", false);
            switch (AddToppingOption) {
                case "1":
                    processSelectMeatRequest();
                    break;
                case "2":
                    processSelectCheeseRequest();
                    break;
                case "3":
                    processOtherToppingRequest();
                    break;
                case "4":
                    processSelectSauceRequest();
                    break;
                case "5":
                    exit = processCompleteRequest();
                    break;
                case "0":
                    toppings = null;
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }

        }
    }

    private boolean processCompleteRequest() {
        if (toppings.stream().anyMatch(t -> t instanceof Meat) && toppings.stream().anyMatch(t -> t instanceof Cheese)) {
            return true;
        } else {
            System.out.println(RED + "You need to select both Cheese and Meat" + RESET);
            return false;
        }
    }

    private void processSelectSauceRequest() {
    }

    private void processOtherToppingRequest() {
    }

    private void processSelectCheeseRequest() {
        String cheeseType = null;
        boolean exit = false;
        while (!exit) {
            String cheeseOption = (String) promptUser("Select Cheese\n" +
                    "1 - American       "  + (!toppings.isEmpty()  && containPremiumTopping("American") ? "✓\n" : "\n" ) +
                    "2 - Provolone       "  + (!toppings.isEmpty()  && containPremiumTopping("Provolone") ? "✓\n" : "\n" ) +
                    "3 - Cheddar      " + (!toppings.isEmpty()  && containPremiumTopping("Cheddar") ? "✓\n" : "\n" ) +
                    "4 - Swiss      " + (!toppings.isEmpty()  && containPremiumTopping("Swiss") ? "✓\n" : "\n" ) +
                    "0 - Back\n", "string", false);
            switch (cheeseOption) {
                case "1":
                    cheeseType = "American";
                    exit = true;
                    break;
                case "2":
                    cheeseType = "Provolone";
                    exit = true;
                    break;
                case "3":
                    cheeseType = "Cheddar";
                    exit = true;
                    break;
                case "4":
                    cheeseType = "Swiss";
                    exit = true;
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
        Boolean extraCheese = null;
        if (cheeseType != null) {
            exit = false;
            while (!exit) {
                String ExtraMeatOption = (String) promptUser("Extra Cheese?\n" +
                        "1 - Yes       "  + (!toppings.isEmpty()  && isExtraCheeseTopping(true) ? "✓\n" : "\n" ) +
                        "2 - No       "  + (!toppings.isEmpty()  && isExtraCheeseTopping(false) ? "✓\n" : "\n" ), "string", false);
                switch (ExtraMeatOption) {
                    case "1":
                        extraCheese = true;
                        exit = true;
                        break;
                    case "2":
                        extraCheese = false;
                        exit = true;
                        break;
                    default:
                        System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
                }
            }

            if (toppings.stream().anyMatch(t -> t instanceof Cheese)) {
                // modify meat type if selected
                for (Topping t : toppings) {
                    if (t instanceof Cheese) {
                        ((Cheese) t).setExtra(extraCheese);
                        t.setType(cheeseType);
                        break;
                    }
                }
            } else {
                // add new meat type to topping
                Cheese cheese = new Cheese(cheeseType, extraCheese);
                toppings.add(cheese);
            }
        }
    }

    private void processSelectMeatRequest() {
        String meatType = null;
        boolean exit = false;
        while (!exit) {
            String meatOption = (String) promptUser("Select Meat\n" +
                    "1 - Steak       "  + (!toppings.isEmpty()  && containPremiumTopping("Steak") ? "✓\n" : "\n" ) +
                    "2 - Ham       "  + (!toppings.isEmpty()  && containPremiumTopping("Ham") ? "✓\n" : "\n" ) +
                    "3 - Salami      " + (!toppings.isEmpty()  && containPremiumTopping("Salami") ? "✓\n" : "\n" ) +
                    "4 - Roast Beef      " + (!toppings.isEmpty()  && containPremiumTopping("Roast Beef") ? "✓\n" : "\n" ) +
                    "5 - Chicken      " + (!toppings.isEmpty()  && containPremiumTopping("Chicken") ? "✓\n" : "\n" ) +
                    "6 - Bacon      " + (!toppings.isEmpty()  && containPremiumTopping("Bacon") ? "✓\n" : "\n" ) +
                    "0 - Back\n", "string", false);
            switch (meatOption) {
                case "1":
                    meatType = "Steak";
                    exit = true;
                    break;
                case "2":
                    meatType = "Ham";
                    exit = true;
                    break;
                case "3":
                    meatType = "Salami";
                    exit = true;
                    break;
                case "4":
                    meatType = "Roast Beef";
                    exit = true;
                    break;
                case "5":
                    meatType = "Chicken";
                    exit = true;
                    break;
                case "6":
                    meatType = "Bacon";
                    exit = true;
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
        Boolean extraMeat = null;
        if (meatType != null) {
            exit = false;
            while (!exit) {
                String ExtraMeatOption = (String) promptUser("Extra Meat?\n" +
                        "1 - Yes       "  + (!toppings.isEmpty()  && isExtraMeatTopping(true) ? "✓\n" : "\n" ) +
                        "2 - No       "  + (!toppings.isEmpty()  && isExtraMeatTopping(false) ? "✓\n" : "\n" ), "string", false);
                switch (ExtraMeatOption) {
                    case "1":
                        extraMeat = true;
                        exit = true;
                        break;
                    case "2":
                        extraMeat = false;
                        exit = true;
                        break;
                    default:
                        System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
                }
            }

            if (toppings.stream().anyMatch(t -> t instanceof Meat)) {
                // modify meat type if selected
                for (Topping t : toppings) {
                    if (t instanceof Meat) {
                        ((Meat) t).setExtra(extraMeat);
                        ((Meat) t).setType(meatType);
                        break;
                    }
                }
            } else {
                // add new meat type to topping
                Meat meat = new Meat(meatType, extraMeat);
                toppings.add(meat);
            }
        }
    }

    private boolean containPremiumTopping(String type) {
        for (Topping t : toppings) {
            if (t instanceof PremiumTopping) {
                if (t.getType().equalsIgnoreCase(type)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExtraMeatTopping(boolean isExtra) {
        for (Topping t : toppings) {
            if (t instanceof Meat) {
                return ((Meat) t).isExtra() == isExtra;
            }

        }
        return false;
    }

    private boolean isExtraCheeseTopping(boolean isExtra) {
        for (Topping t : toppings) {
            if (t instanceof Cheese) {
                return ((Cheese) t).isExtra() == isExtra;
            }
        }
        return false;
    }
}
