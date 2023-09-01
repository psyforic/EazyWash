package com.example.eazywash.models;

public class ClothingItems {
    private int quantity;
    private String Item;
    private double price;

    private double total;

    public ClothingItems() {
    }

    public ClothingItems(int quantity, String item, double price) {
       this.quantity = quantity;
       Item = item;
       this.price = price;
   }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
