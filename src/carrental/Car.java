package carrental;

import java.util.UUID;

public abstract class Car implements Rentable {
    protected String id;
    protected String plateNumber;
    protected String brand;
    protected String model;
    protected int year;
    protected double dailyPrice;
    protected boolean isAvailable;
    protected Customer currentRenter;

    public Car(String plateNumber, String brand, String model, int year, double dailyPrice) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.isAvailable = true;
    }

    @Override
    public boolean rent(Customer customer, int days) {
        if (isAvailable) {
            this.isAvailable = false;
            this.currentRenter = customer;
            System.out.println("✓ " + customer.getName() + " rented " + brand + " " + model + " for " + days + " days");
            return true;
        }
        System.out.println("✗ " + brand + " " + model + " is not available for rent");
        return false;
    }

    @Override
    public boolean returnVehicle() {
        if (!isAvailable) {
            this.isAvailable = true;
            this.currentRenter = null;
            System.out.println("↻ " + brand + " " + model + " has been returned");
            return true;
        }
        return false;
    }

    @Override
    public double calculateRentalFee(int days) {
        return dailyPrice * days;  //  
    }

    // Getters
    public String getId() { return id; }
    public String getPlateNumber() { return plateNumber; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getDailyPrice() { return dailyPrice; }
    public boolean isAvailable() { return isAvailable; }
    public String getCarInfo() {
        return brand + " " + model + " (" + year + ") - " + plateNumber;
    }
}