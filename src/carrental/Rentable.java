package carrental;

public interface Rentable {
    boolean rent(Customer customer, int days);
    boolean returnVehicle();
    double calculateRentalFee(int days);
}