package com.ires.computers.models;

import java.time.LocalDate;

public class Computer
{
    private int id;
    private String name;
    private double price;
    private boolean isInStock;
    private LocalDate releaseDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIsInStock() {
        return isInStock;
    }
    public void setIsInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
