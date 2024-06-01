package com.skillsunion.springbootdemo;

import java.util.UUID;

public class Product {
    String id;
    String name;
    Double price;
    String description;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public Product(String name, Double price, String description) {
        this();
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
