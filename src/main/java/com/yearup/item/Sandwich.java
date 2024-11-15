package com.yearup.item;

import com.yearup.topping.PremiumTopping;
import com.yearup.topping.Topping;

import java.util.List;

public class Sandwich extends Item{
    private String size;
    private String bread;
    private List<Topping> toppings;
    private Boolean isToasted;

    public Sandwich(String size, String bread, List<Topping> toppings, boolean isToasted) {
        super();
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

    public Sandwich() {
        super();
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
                toppingPrice += ((PremiumTopping) topping).getPriceBySize(this.size);
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

    public Boolean isToasted() {

        return isToasted;
    }

    public void setToasted(boolean toasted) {

        isToasted = toasted;
    }

    @Override
    public String toString() {

        StringBuilder toppingsList = new StringBuilder();

        for (Topping topping : toppings) {
            toppingsList.append("\n    - ").append(topping.getType());
            if (topping instanceof PremiumTopping) {
                toppingsList.append("    - Extra: ").append(((PremiumTopping) topping).isExtra() ? "Yes" : "No");
            }
        }
        return "Sandwich Details:" +
                " size=" + size  +
                ", bread=" + bread +
                ", price=$" + getPrice() +
                ", quantity=" + getQuantity() +
                ", isToasted=" + isToasted +
                ", toppings=" + toppingsList.toString();
    }
}
