package carrental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private String id;
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private double totalFee;
    private boolean isActive;
    private String damageReport; // optional feature

    public Rental(Car car, Customer customer, int days) {
        this.id = "RENT" + System.currentTimeMillis() % 10000;
        this.car = car;
        this.customer = customer;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusDays(days);
        this.days = days;
        this.totalFee = car.calculateRentalFee(days);
        this.isActive = true;
        
        if (car.rent(customer, days)) {
            customer.addRentalToHistory(this);
            System.out.println("💰 Total: " + totalFee + " TL");
        }
    }

    public void returnCar() {
        if (isActive) {
            car.returnVehicle();
            this.isActive = false;
            
            // Check for late return
            long overdueDays = ChronoUnit.DAYS.between(endDate, LocalDate.now());
            if (overdueDays > 0) {
                double penalty = overdueDays * car.getDailyPrice() * 0.2; // 20% penalty
                System.out.println("⚠️  Late return: " + overdueDays + " days - Penalty: " + penalty + " TL");
                totalFee += penalty;
            }
        }
    }

    // Optional feature: Damage report
    public void setDamageReport(String report) {
        this.damageReport = report;
        if (report != null && !report.isEmpty()) {
            System.out.println("📄 Damage report added");
        }
    }
 
    // Getters
    public String getId() { return id; }
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public int getDays() { return days; }
    public double getTotalFee() { return totalFee; }
    public boolean isActive() { return isActive; }
    public String getDamageReport() { return damageReport; }
    
    public String getRentalInfo() {
        return car.getBrand() + " " + car.getModel() + " - " + days + " days - " + totalFee + " TL";
    }
}