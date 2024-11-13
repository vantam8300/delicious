package com.yearup.topping;

import java.util.HashMap;
import java.util.Map;

public class PremiumTopping extends Topping{
    private boolean isExtra;
    private static final Map<String, Map<String, Double>> prices = new HashMap<>();

    static {
        // Initialize prices for the 4-inch sandwich
        Map<String, Double> pricesFor4Inch = new HashMap<>();
        pricesFor4Inch.put("Steak", 1.00);
        pricesFor4Inch.put("Ham", 1.00);
        pricesFor4Inch.put("Salami", 1.00);
        pricesFor4Inch.put("Roast Beef", 1.00);
        pricesFor4Inch.put("Chicken", 1.00);
        pricesFor4Inch.put("Bacon", 1.00);
        pricesFor4Inch.put("American", 0.75);
        pricesFor4Inch.put("Provolone", 0.75);
        pricesFor4Inch.put("Cheddar", 0.75);
        pricesFor4Inch.put("Swiss", 0.75);
        prices.put("4", pricesFor4Inch);

        // Initialize prices for the 8-inch sandwich
        Map<String, Double> pricesFor8Inch = new HashMap<>();
        pricesFor8Inch.put("Steak", 2.00);
        pricesFor8Inch.put("Ham", 2.00);
        pricesFor8Inch.put("Salami", 2.00);
        pricesFor8Inch.put("Roast Beef", 2.00);
        pricesFor8Inch.put("Chicken", 2.00);
        pricesFor8Inch.put("Bacon", 2.00);
        pricesFor8Inch.put("American", 1.50);
        pricesFor8Inch.put("Provolone", 1.50);
        pricesFor8Inch.put("Cheddar", 1.50);
        pricesFor8Inch.put("Swiss", 1.50);
        prices.put("8", pricesFor8Inch);

        // Initialize prices for the 12-inch sandwich
        Map<String, Double> pricesFor12Inch = new HashMap<>();
        pricesFor12Inch.put("Steak", 3.00);
        pricesFor12Inch.put("Ham", 3.00);
        pricesFor12Inch.put("Salami", 3.00);
        pricesFor12Inch.put("Roast Beef", 3.00);
        pricesFor12Inch.put("Chicken", 3.00);
        pricesFor12Inch.put("Bacon", 3.00);
        pricesFor12Inch.put("American", 2.25);
        pricesFor12Inch.put("Provolone", 2.25);
        pricesFor12Inch.put("Cheddar", 2.25);
        pricesFor12Inch.put("Swiss", 2.25);
        prices.put("12", pricesFor12Inch);
    }
    public PremiumTopping(String type, boolean isExtra) {
        super(type);
        this.isExtra = isExtra;
    }

    public PremiumTopping(String type) {
        super(type);
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    @Override
    public double getPriceBySize(String size) {
        // get the prices map for the given size
        Map<String, Double> pricesForSize = prices.get(size);

        Double toppingPrice = pricesForSize.get(super.getType());

        // Return 0 if the topping is not found for the size
        if (toppingPrice == null) {
            return 0.0;
        }

        if (isExtra && isMeatTopping(super.getType())) {
            return toppingPrice * 1.5;
        } else if (isExtra && isCheeseTopping(super.getType())) {
            return toppingPrice * 1.4;
        } else {
            return toppingPrice;

        }
    }

    private boolean isCheeseTopping(String topping) {
        return topping.equals("American") || topping.equals("Provolone") || topping.equals("Cheddar") || topping.equals("Swiss");

    }

    private static boolean isMeatTopping(String topping) {
        return topping.equals("Steak") || topping.equals("Ham") || topping.equals("Salami") || topping.equals("Roast beef") || topping.equals("Chicken") || topping.equals("Bacon");
    }
}
