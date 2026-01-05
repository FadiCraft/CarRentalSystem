package carrental;

public class GasCar extends Car {
    private String fuelType; // Gasoline, Diesel
    private double fuelConsumption; // L/100km

    public GasCar(String plateNumber, String brand, String model, int year, 
                 double dailyPrice, String fuelType, double fuelConsumption) {
        super(plateNumber, brand, model, year, dailyPrice);
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public double calculateRentalFee(int days) {
        double baseFee = getDailyPrice() * days;
        double fuelSurcharge = baseFee * 0.05; // 5% fuel surcharge
        return baseFee + fuelSurcharge;
    }

    // Calculate fuel consumption (optional feature)
    public double calculateFuelConsumption(double distance) {
        return (fuelConsumption * distance) / 100;
    }

    public String getFuelType() { return fuelType; }
    public double getFuelConsumption() { return fuelConsumption; }
     
    @Override
    public String toString() {
        return getCarInfo() + " [" + fuelType + " - " + fuelConsumption + "L/100km]";
    }
}