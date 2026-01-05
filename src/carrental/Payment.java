package carrental;

import java.time.LocalDateTime;

public class Payment {
    private String id;
    private Rental rental;
    private double amount; 
    private LocalDateTime paymentDate;
    private String paymentMethod; // Cash, Card 
    private boolean isPaid;

    public Payment(Rental rental, String paymentMethod) {
        this.id = "PAY" + System.currentTimeMillis() % 10000;
        this.rental = rental;
        this.amount = rental.getTotalFee();
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDateTime.now();
        this.isPaid = true;
        
        System.out.println("💳 Payment ID: " + id);
        System.out.println("   Amount: " + amount + " TL");
        System.out.println("   Method: " + paymentMethod);
        System.out.println("   Date: " + paymentDate);
        System.out.println("✅ Payment completed successfully");
    }

    public void printReceipt() {
        System.out.println("\n=========================");
        System.out.println("       PAYMENT RECEIPT       ");
        System.out.println("=========================");
        System.out.println("Payment ID: " + id);
        System.out.println("Customer: " + rental.getCustomer().getName());
        System.out.println("Car: " + rental.getCar().getBrand() + " " + rental.getCar().getModel());
        System.out.println("Duration: " + rental.getDays() + " days");
        System.out.println("Amount: " + amount + " TL");
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Date: " + paymentDate);
        System.out.println("=========================\n");
    }

    // Getters
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public boolean isPaid() { return isPaid; }
}