package carrental;

public class ElectricCar extends Car {
    private double batteryCapacity; // kWh
    private double chargingTime; // hours

    public ElectricCar(String plateNumber, String brand, String model, int year, 
                      double dailyPrice, double batteryCapacity, double chargingTime) {
        super(plateNumber, brand, model, year, dailyPrice);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }
   
    @Override
    public double calculateRentalFee(int days) {
        double baseFee = getDailyPrice() * days;
        double discount = baseFee * 0.10; // 10% discount for electric cars
        return baseFee - discount;
    }

    public double getBatteryCapacity() { return batteryCapacity; }
    public double getChargingTime() { return chargingTime; }
    
    @Override
    public String toString() {
        return getCarInfo() + " [Electric - " + batteryCapacity + "kWh]";
    }
}