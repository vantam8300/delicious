package com.yearup;

import java.util.HashMap;
import java.util.Map;

public class PremiumTopping extends Topping{
    private boolean isExtra;
    private static final Map<String, Map<String, Double>> prices = new HashMap<>();

    static {
        // Initialize prices for the 4-inch sandwich
        Map<String, Double> pricesFor4Inch = new HashMap<>();
        pricesFor4Inch.put("steak", 1.00);
        pricesFor4Inch.put("ham", 1.00);
        pricesFor4Inch.put("salami", 1.00);
        pricesFor4Inch.put("roast beef", 1.00);
        pricesFor4Inch.put("chicken", 1.00);
        pricesFor4Inch.put("bacon", 1.00);
        pricesFor4Inch.put("american cheese", 0.75);
        pricesFor4Inch.put("provolone cheese", 0.75);
        pricesFor4Inch.put("cheddar cheese", 0.75);
        pricesFor4Inch.put("swiss cheese", 0.75);
        prices.put("4", pricesFor4Inch);

        // Initialize prices for the 8-inch sandwich
        Map<String, Double> pricesFor8Inch = new HashMap<>();
        pricesFor8Inch.put("steak", 2.00);
        pricesFor8Inch.put("ham", 2.00);
        pricesFor8Inch.put("salami", 2.00);
        pricesFor8Inch.put("roast beef", 2.00);
        pricesFor8Inch.put("chicken", 2.00);
        pricesFor8Inch.put("bacon", 2.00);
        pricesFor8Inch.put("american cheese", 1.50);
        pricesFor8Inch.put("provolone cheese", 1.50);
        pricesFor8Inch.put("cheddar cheese", 1.50);
        pricesFor8Inch.put("swiss cheese", 1.50);
        prices.put("8", pricesFor8Inch);

        // Initialize prices for the 12-inch sandwich
        Map<String, Double> pricesFor12Inch = new HashMap<>();
        pricesFor12Inch.put("steak", 3.00);
        pricesFor12Inch.put("ham", 3.00);
        pricesFor12Inch.put("salami", 3.00);
        pricesFor12Inch.put("roast beef", 3.00);
        pricesFor12Inch.put("chicken", 3.00);
        pricesFor12Inch.put("bacon", 3.00);
        pricesFor12Inch.put("american cheese", 2.25);
        pricesFor12Inch.put("provolone cheese", 2.25);
        pricesFor12Inch.put("cheddar cheese", 2.25);
        pricesFor12Inch.put("swiss cheese", 2.25);
        prices.put("12", pricesFor12Inch);
    }
    public PremiumTopping(String type, boolean isExtra) {
        super(type);
        this.isExtra = isExtra;
    }

    @Override
    public double getPriceBySize(String size) {
        // get the prices map for the given size
        Map<String, Double> pricesForSize = prices.get(size);

        Double basePrice = pricesForSize.get(super.getType());

        // Return 0 if the topping is not found for the size
        if (basePrice == null) {
            return 0.0;
        }

        if (isExtra && isMeatTopping(super.getType())) {
            return basePrice * 1.5;
        } else if (isExtra && isCheeseTopping(super.getType())) {
            return basePrice * 1.4;
        } else {
            return basePrice;

        }
    }

    private boolean isCheeseTopping(String topping) {
        return topping.equals("american cheese") || topping.equals("provolone cheese") || topping.equals("cheddar cheese") || topping.equals("swiss cheese");

    }

    private static boolean isMeatTopping(String topping) {
        return topping.equals("steak") || topping.equals("ham") || topping.equals("salami") || topping.equals("roast beef") || topping.equals("chicken") || topping.equals("bacon");
    }
}
