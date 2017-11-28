package com.eliezer.myapplication.model.entities;

/**
 * Created by Eliezer on 20/11/2017.
 */

//Base class to hold information about the property
public class Property {

    //property basics
    private int streetNumber;
    private String streetName;
    private String suburb;
    private String state;
    private String description;
    private String image;
    private Double price;
    private int bedrooms;
    private int bathrooms;
    private int carspots;

    //constructor
    public Property(int streetNumber, String streetName, String suburb, String state, String description, Double price, String image, int bedrooms, int bathrooms, int carspots) {

        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.state = state;
        this.description = description;
        this.price = price;
        this.image = image;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.carspots = carspots;
    }

    //getters
    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getCarspots() {
        return carspots;
    }
}
