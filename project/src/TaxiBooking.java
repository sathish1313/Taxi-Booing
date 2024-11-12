import java.util.ArrayList;

public class TaxiBooking {
    private static ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
    private static int taxiListLimit = 4;
    private static int idGenerator = 1;
    static ArrayList<Taxi> taxiBookedHistory = new ArrayList<Taxi>();

    public static String booking(String pickupLocation, String dropLocation, int pickupTime, double kilometers) throws CloneNotSupportedException {
        if (taxiList.size() < taxiListLimit) {
            taxiList.add(new Taxi());
        }

        int min = Integer.MAX_VALUE;
        Taxi taxiReady = null;

        for (Taxi t : taxiList) {
            if (t.getDropTime() <= pickupTime && Math.abs(pickupLocation.charAt(0) - t.getCurrentLocation().charAt(0)) <= min) {
                if (Math.abs(pickupLocation.charAt(0) - t.getCurrentLocation().charAt(0)) == min) {
                    // if Math.abs(..) is equal to min, the taxi with lowest earnings will be put in taxiReady object
                    if (taxiReady != null && t.getEarnings() < taxiReady.getEarnings()) {
                        taxiReady = t;
                    }
                } else {
                    taxiReady = t;
                    min = Math.abs(pickupLocation.charAt(0) - t.getCurrentLocation().charAt(0));
                }
            }
        }

        if (taxiReady != null) {
            taxiReady.setCustomerId(idGenerator++);
            taxiReady.setPickupTime(pickupTime);
            taxiReady.setPickupLocation(pickupLocation);
            taxiReady.setDropLocation(dropLocation);
            taxiReady.setCurrentLocation(dropLocation);
            taxiReady.setDropTime(pickupTime + (int)(kilometers * 60)); // Convert kilometers to minutes
            taxiReady.setEarnings((taxiReady.getEarnings()) + (kilometers * 1.5) + 100); // Fare calculation
            taxiReady.setTaxiId(taxiList.indexOf(taxiReady) + 1);
            taxiBookedHistory.add((Taxi) taxiReady.clone()); //clone object
        }

        return taxiReady != null ? "Taxi number " + taxiReady.getTaxiId() + " is booked!" : "Taxis not available";
    }

    public static void display() {
        System.out.println("-----------------");
        for (Taxi t : taxiBookedHistory) {
            System.out.println(t.toString());
            System.out.println("-----------------");
        }
    }
}
