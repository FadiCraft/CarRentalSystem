package carrental;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Starting Car Rental System\n");
        
        try {
            // 1. Create inventory
            CarInventory inventory = new CarInventory();

            // 2. Add cars
            Car tesla = new ElectricCar("34ABC123", "Tesla", "Model 3", 2023, 500, 75, 8);
            Car toyota = new GasCar("34XYZ789", "Toyota", "Corolla", 2022, 300, "Gasoline", 6.5);
            Car bmw = new GasCar("34DEF456", "BMW", "320i", 2023, 700, "Gasoline", 8.0);
            
            inventory.addCar(tesla);
            inventory.addCar(toyota);
            inventory.addCar(bmw);
            

            // 3. Show all cars
            inventory.listAllCars();

            // 4. Create customer
            Customer ahmet = new Customer("Ahmet", "05551234567", "ahmet@email.com");

            // 5. Rent a car
            System.out.println("\n--- Rental Process ---");
            Rental rental1 = new Rental(tesla, ahmet, 5);
            
            // 6. Payment
            Payment payment1 = new Payment(rental1, "Credit Card");
            payment1.printReceipt();

            // 7. Check available cars
            inventory.listAvailableCars();

            // 8. Return car
            System.out.println("\n--- Return Process ---");
            rental1.returnCar();

            // 9. Show customer rental history
            ahmet.printRentalHistory();

            // 10. Use filtering feature
            System.out.println("\n--- Filter by Brand ---");
            System.out.println("Toyota cars:");
            inventory.filterByBrand("Toyota").forEach(car -> System.out.println("   " + car));

            // 11. Remove car
            inventory.removeCar("34XYZ789");

            // 12. Show final status
            System.out.println("\n📈 Final Status:");
            inventory.listAllCars();
            
        } catch (Exception e) {
            System.out.println("❌ Error occurred: " + e.getMessage());
        }
        
        System.out.println("\n✅ Program finished successfully!");
    }
}