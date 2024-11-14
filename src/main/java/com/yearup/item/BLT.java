package com.yearup.item;

import com.yearup.topping.Topping;

import java.util.List;

public class BLT extends Sandwich{
    public BLT(String size, String bread, List<Topping> toppings, boolean isToasted) {
        super(size, bread, toppings, isToasted);
    }
}
