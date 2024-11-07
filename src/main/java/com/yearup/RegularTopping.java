package com.yearup;

import java.util.List;

public class RegularTopping extends Topping{

    public RegularTopping(String type) {
        super(type);
    }

    @Override
    public double getPriceBySize(String size) {
        return 0.0;  // Regular toppings are free
    }
}
