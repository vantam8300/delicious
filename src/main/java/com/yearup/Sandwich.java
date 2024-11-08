package com.yearup;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Item{
    private String size;
    private String bread;
    private double price;
    private List<Topping> toppings;
    private boolean isToasted;

    public void addTopping(Topping topping) {

        toppings.add(topping);
    }

    public Sandwich(String size, String bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        toppings = new ArrayList<>();
    }

    public Sandwich(String size, String bread, double price, List<Topping> toppings, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.price = price;
        this.toppings = toppings;
        this.isToasted = isToasted;
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

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
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
                ", price=" + price +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}
