package com.jamalicia.carros.java.entities;

public class CarOriginal {

    public int id;
    public String model;
    public int horsePower;
    public Double price;

    public CarOriginal(int id, String model, int horsePower, Double price){
        this.id = id;
        this.model = model;
        this.horsePower = horsePower;
        this.price = price;
    }
}
