import java.util.ArrayList;

public class Taxi {
    private String currentLocation = "A";
    private int customerId;
    private int taxiId;
    private String pickupLocation;
    private String dropLocation;
    private int pickupTime;
    private int dropTime;
    private double earnings;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    @Override
    public String toString() {
        return "Taxi " + getTaxiId() + "\nCurrent Location: " + currentLocation +
                "\nCustomer ID: " + customerId + "\nPickup Location: " + pickupLocation +
                "\nDrop Location: " + dropLocation + "\nPickup Time: " + pickupTime +
                "\nDrop Time: " + dropTime + "\nEarnings: $" + earnings;
    }
}

