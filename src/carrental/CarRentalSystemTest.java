package carrental;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarRentalSystemTest {
    
    @Test
    void testGasCarCreation() {
        Car car = new GasCar("34ABC123", "Toyota", "Corolla", 2022, 300, "Gasoline", 6.5);
        
        assertNotNull(car);
        assertEquals("Toyota", car.getBrand());
        assertEquals(2022, car.getYear());
        assertTrue(car.isAvailable());
    } 
    
    @Test
    void testElectricCarCreation() {
        Car car = new ElectricCar("34TES123", "Tesla", "Model 3", 2023, 500, 75, 8);
        
        assertNotNull(car);
        assertEquals("Tesla", car.getBrand());
        assertEquals(2023, car.getYear());
        assertTrue(car.isAvailable());
    }
    
    @Test
    void testRentCar() {
        Car car = new GasCar("34XYZ789", "BMW", "320i", 2023, 700, "Gasoline", 8.0);
        Customer customer = new Customer("Ahmet", "05551234567", "ahmet@email.com");
        
        assertTrue(car.isAvailable());
        assertTrue(car.rent(customer, 3));
        assertFalse(car.isAvailable());
    }
    
    @Test
    void testElectricCarPrice() {
        ElectricCar tesla = new ElectricCar("34TES123", "Tesla", "Model 3", 2023, 500, 75, 8);
        
        double expected = 1350.0;
        double actual = tesla.calculateRentalFee(3);
        
        assertEquals(expected, actual, 0.01);
    }
       
    @Test
    void testGasCarPrice() {
        GasCar toyota = new GasCar("34TOY456", "Toyota", "Corolla", 2022, 300, "Gasoline", 6.5);
        
        double expected = 1260.0;
        double actual = toyota.calculateRentalFee(4);
        
        assertEquals(expected, actual, 0.01);
    }
    
    @Test
    void testReturnCar() {
        Car car = new GasCar("34BMW789", "BMW", "X5", 2023, 800, "Gasoline", 10.0);
        Customer customer = new Customer("Mehmet", "05559876543", "mehmet@email.com");
        
        assertTrue(car.rent(customer, 2));
        assertFalse(car.isAvailable());
        
        assertTrue(car.returnVehicle());
        assertTrue(car.isAvailable());
    }
}