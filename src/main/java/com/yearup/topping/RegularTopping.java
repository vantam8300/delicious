package com.yearup.topping;

public class RegularTopping extends Topping{

    public RegularTopping(String type) {
        super(type);
    }

    public double getPriceBySize(String size) {
        return 0.0;  // Regular toppings are free
    }
}
