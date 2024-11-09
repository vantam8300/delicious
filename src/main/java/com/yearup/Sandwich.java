package com.yearup;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Item{
    private String size;
    private String bread;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(int quantity, String size, String bread, List<Topping> toppings, boolean isToasted) {
        super(quantity);
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

    public void addTopping(Topping topping) {

        toppings.add(topping);
    }

    public void setSize(String size) {

        this.size = size;
    }

    public String getSize() {

        return size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {

        this.bread = bread;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double getPrice() {
        double basePrice = 0.0;

        if (this.size.equals("4")) {
            basePrice = 5.50;
        } else if (this.size.equals("8")) {
            basePrice = 7.00;
        } else if (this.size.equals("12")) {
            basePrice = 8.5;
        }

        double toppingPrice = 0;
        for (Topping topping : toppings) {
            if (topping instanceof PremiumTopping) {
                toppingPrice += topping.getPriceBySize(this.size);
            }
        }

        return basePrice + toppingPrice;
    }

    public List<Topping> getToppings() {

        return toppings;
    }

    public void setToppings(List<Topping> toppings) {

        this.toppings = toppings;
    }

    public boolean isToasted() {

        return isToasted;
    }

    public void setToasted(boolean toasted) {

        isToasted = toasted;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "size='" + size + '\'' +
                ", bread='" + bread + '\'' +
                ", price=" + getPrice() +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}
