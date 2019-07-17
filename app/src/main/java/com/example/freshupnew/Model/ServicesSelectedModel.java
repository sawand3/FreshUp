package com.example.freshupnew.Model;

public class ServicesSelectedModel {
    String name;
    String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ServicesSelectedModel(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
