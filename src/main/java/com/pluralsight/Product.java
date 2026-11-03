package com.pluralsight;

public class Product {

    private String Name;
    private int id;
    private double Price;


    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString(){
        return String.format("ID: %d | Name: %s | Price: $%.2f", id, Name, Price);
    }

}
