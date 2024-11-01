package com.pluralsight;

public class Vehicle {

    private int vin;
    private int year;
    private int odometer;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //override
    @Override
    public String toString() {
        return "VIN: " + vin +
                ", Year: " + year +
                ", Make: " + make +
                ", Model: " + model +
                ", Type: " + vehicleType +
                ", Color: " + color +
                ", Odometer: " + odometer +
                ", Price: $" + price;
    }



}
