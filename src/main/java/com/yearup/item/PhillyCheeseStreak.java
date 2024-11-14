package com.yearup.item;

import com.yearup.topping.Topping;

import java.util.List;

public class PhillyCheeseStreak extends Sandwich{

    public PhillyCheeseStreak(String size, String bread, List<Topping> toppings, boolean isToasted) {
        super(size, bread, toppings, isToasted);
    }
}
