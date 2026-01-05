package carrental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;
    private List<Rental> rentalHistory;
   
    public Customer(String name, String phone, String email) {
        this.id = "CUST" + System.currentTimeMillis() % 10000;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rentalHistory = new ArrayList<>();
    }

    public void addRentalToHistory(Rental rental) {
        rentalHistory.add(rental);
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public List<Rental> getRentalHistory() { return rentalHistory; }
    
    public void printRentalHistory() {
        System.out.println("\nRental History for " + name + ":");
        if (rentalHistory.isEmpty()) {
            System.out.println("   No previous rentals");
        } else {
            for (Rental rental : rentalHistory) {
                System.out.println("   - " + rental.getRentalInfo());
            }
        }
    }
}