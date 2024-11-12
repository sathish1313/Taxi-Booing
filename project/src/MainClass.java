import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        boolean loop = true;

        while (loop) {
            System.out.println("Choose any one\n1.Book Taxi\n2.Display Details\n3.Exit");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();

            switch (n) {
                case 1: {
                    System.out.println("Enter Pickup Location:");
                    String pickupLocation = s.next(); // Read pickup location as a string
                    System.out.println("Enter Drop Location:");
                    String dropLocation = s.next(); // Read drop location as a string
                    System.out.println("Enter Pickup Time:");
                    int pickupTime = s.nextInt();
                    System.out.println("Enter Kilometers:");
                    double kilometers = s.nextDouble(); // Read kilometers as a double
                    s.nextLine(); // Consume the newline character after reading the double
                    System.out.println(TaxiBooking.booking(pickupLocation, dropLocation, pickupTime, kilometers));
                    break;
                }


                case 2: {
                    TaxiBooking.display();
                    break;
                }

                case 3: {
                    loop = false;
                    System.out.println("\tThank You!!!");
                    s.close();
                    break;
                }
            }
        }
    }
}
