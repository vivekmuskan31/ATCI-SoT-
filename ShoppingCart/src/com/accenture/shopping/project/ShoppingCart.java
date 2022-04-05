package com.accenture.shopping.project;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public ShoppingCart() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public double computeTotalPrice(){
        double total = 0d;
        for(Item i: items) total += i.getPrice();
        return total;
    }
}
