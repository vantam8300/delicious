package com.yearup.screen;

import com.yearup.topping.*;

import java.util.ArrayList;
import java.util.List;

import static com.yearup.util.Util.*;

public class AddToppingScreen {
    List<Topping> toppings;

    // Create List of toppings to store user input data
    public AddToppingScreen() {
        toppings = new ArrayList<>();
    }

    public AddToppingScreen(List<Topping> toppings) {
        this.toppings = toppings;
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
        String sauceType = null;
        boolean exit = false;
        while (!exit) {
            String sauceOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Mayo      " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Mayo")) ? "✓\n" : "\n" ) +
                            "2 - Mustard      " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Mustard")) ? "✓\n" : "\n" ) +
                            "3 - Ketchup       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Ketchup")) ? "✓\n" : "\n" ) +
                            "4 - Ranch       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Ranch")) ? "✓\n" : "\n" ) +
                            "5 - Thousand islands       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Thousand islands")) ? "✓\n" : "\n" ) +
                            "6 - Vinaigrette       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Vinaigrette")) ? "✓\n" : "\n" ) +
                            "0 - Go Back\n" , "string", false);
            switch (sauceOption) {
                case "1":
                    sauceType = "Mayo";
                    exit = true;
                    break;
                case "2":
                    sauceType = "Mustard";
                    exit = true;
                    break;
                case "3":
                    sauceType = "Ketchup";
                    exit = true;
                    break;
                case "4":
                    sauceType = "Ranch";
                    exit = true;
                    break;
                case "5":
                    sauceType = "Thousand islands";
                    exit = true;
                    break;
                case "6":
                    sauceType = "Vinaigrette";
                    exit = true;
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
        if (sauceType != null) {
            String finalSauceType = sauceType;
            if (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase(finalSauceType))) {
                // delete topping type if selected
                for (Topping t : toppings) {
                    if (t.getType().equalsIgnoreCase(sauceType)) {
                        toppings.remove(t);
                        break;
                    }
                }
            } else {
                Sauce  sauce = new Sauce(sauceType);
                toppings.add(sauce);
            }
        }
    }

    private void processOtherToppingRequest() {
        String toppingType = null;
        boolean exit = false;
        while (!exit) {
            String AddOtherToppingOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Lettuce      " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Lettuce")) ? "✓\n" : "\n" ) +
                            "2 - Peppers      " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Peppers")) ? "✓\n" : "\n" ) +
                            "3 - Onions       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Onions")) ? "✓\n" : "\n" ) +
                            "4 - Tomatoes       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Tomatoes")) ? "✓\n" : "\n" ) +
                            "5 - Jalepenos       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Jalepenos")) ? "✓\n" : "\n" ) +
                            "6 - Cucumbers       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Cucumbers")) ? "✓\n" : "\n" ) +
                            "7 - Pickles       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Pickles")) ? "✓\n" : "\n" ) +
                            "8 - Guacamole       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Guacamole")) ? "✓\n" : "\n" ) +
                            "9 - Mushrooms       " + (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase("Mushrooms")) ? "✓\n" : "\n" ) +
                            "0 - Go Back\n" , "string", false);
            switch (AddOtherToppingOption) {
                case "1":
                    toppingType = "Lettuce";
                    exit = true;
                    break;
                case "2":
                    toppingType = "Peppers";
                    exit = true;
                    break;
                case "3":
                    toppingType = "Onions";
                    exit = true;
                    break;
                case "4":
                    toppingType = "Tomatoes";
                    exit = true;
                    break;
                case "5":
                    toppingType = "Jalepenos";
                    exit = true;
                    break;
                case "6":
                    toppingType = "Cucumbers";
                    exit = true;
                    break;
                case "7":
                    toppingType = "Pickles";
                    exit = true;
                    break;
                case "8":
                    toppingType = "Guacamole";
                    exit = true;
                    break;
                case "9":
                    toppingType = "Mushrooms";
                    exit = true;
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
        if (toppingType != null) {
            String finalToppingType = toppingType;
            if (toppings.stream().anyMatch(t -> t.getType().equalsIgnoreCase(finalToppingType))) {
                // delete topping type if selected
                for (Topping t : toppings) {
                    if (t.getType().equalsIgnoreCase(toppingType)) {
                        toppings.remove(t);
                        break;
                    }
                }
            } else {
                OtherTopping  otherTopping = new OtherTopping(toppingType);
                toppings.add(otherTopping);
            }
        }
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
