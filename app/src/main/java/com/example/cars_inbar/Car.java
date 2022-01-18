package com.example.cars_inbar;

import java.io.Serializable;

public class Car implements Serializable {
    private int Photo;
    private String Brand;
    private String Model;
    private String Year;
    private String Price;

    public Car(int photo, String brand, String model, String year, String price) {
        Photo = photo;
        Brand = brand;
        Model = model;
        Year = year;
        Price = price;
    }

    public int getPhoto() {
        return Photo;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public String getYear() {
        return Year;
    }

    public String getPrice() {
        return Price;
    }
}
