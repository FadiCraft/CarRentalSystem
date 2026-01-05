package carrental;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarInventory {
    private ArrayList<Car> cars;

    public CarInventory() { 
        this.cars = new ArrayList<>();
    }
  
    // Add car 
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("+ Added: " + car.getCarInfo());
    }

    // Remove car 
    public boolean removeCar(String plateNumber) {
        Car carToRemove = findCarByPlate(plateNumber);
        if (carToRemove != null) {
            cars.remove(carToRemove);
            System.out.println("- Removed: " + carToRemove.getCarInfo());
            return true;
        }
        System.out.println("X No car found with plate: " + plateNumber);
        return false;
    }

    // Find car by plate number
    public Car findCarByPlate(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        return null;
    }

    // Show available cars
    public void listAvailableCars() {
        System.out.println("\nAvailable Cars:");
        List<Car> availableCars = cars.stream()
            .filter(Car::isAvailable)
            .collect(Collectors.toList());
        
        if (availableCars.isEmpty()) {
            System.out.println("   No cars available at the moment");
        } else {
            availableCars.forEach(car -> System.out.println("   - " + car));
        }
    }

    // Show all cars
    public void listAllCars() {
        System.out.println("\nAll Cars (" + cars.size() + "):");
        if (cars.isEmpty()) {
            System.out.println("   No cars in inventory");
        } else {
            cars.forEach(car -> {
                String status = car.isAvailable() ? "[AVAILABLE]" : "[RENTED]";
                System.out.println("   " + status + " " + car);
            });
        }
    }

    // Filter by brand
    public List<Car> filterByBrand(String brand) {
        return cars.stream()
            .filter(car -> car.getBrand().equalsIgnoreCase(brand))
            .collect(Collectors.toList());
    }

    // Filter by fuel type
    public List<Car> filterByFuelType(String fuelType) {
        return cars.stream()
            .filter(car -> car instanceof GasCar)
            .filter(car -> ((GasCar) car).getFuelType().equalsIgnoreCase(fuelType))
            .collect(Collectors.toList());
    }

    // Getters
    public ArrayList<Car> getCars() { 
        return cars; 
    }
}