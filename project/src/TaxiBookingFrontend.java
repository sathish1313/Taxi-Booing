import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxiBookingFrontend extends JFrame implements ActionListener {
    private JTextField pickupLocationField, dropLocationField, pickupTimeField, kilometersField;
    private JTextArea dropLocationArea, outputArea; // Declaration of dropLocationArea

    private JButton bookTaxiButton, displayHistoryButton;

    public TaxiBookingFrontend() {
        setTitle("Taxi Booking System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Pickup Location (Same as Current Location):"));
        pickupLocationField = new JTextField("Current Location");
        pickupLocationField.setEditable(false); // Set pickup location as non-editable
        inputPanel.add(pickupLocationField);
        inputPanel.add(new JLabel("Drop Location:"));
        dropLocationArea = new JTextArea(2, 5); // Rows, Columns
        inputPanel.add(new JScrollPane(dropLocationArea));
        inputPanel.add(new JLabel("Pickup Time:"));
        pickupTimeField = new JTextField();
        inputPanel.add(pickupTimeField);
        inputPanel.add(new JLabel("Distance (in Kilometers):"));
        kilometersField = new JTextField();
        inputPanel.add(kilometersField);

        bookTaxiButton = new JButton("Book Taxi");
        bookTaxiButton.addActionListener(this);
        displayHistoryButton = new JButton("Display History");
        displayHistoryButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(bookTaxiButton);
        buttonPanel.add(displayHistoryButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookTaxiButton) {
            // Get user input from UI components
            String dropLocation = dropLocationArea.getText(); // Retrieve entire string
            int pickupTime = Integer.parseInt(pickupTimeField.getText());
            double distanceInKilometers = Double.parseDouble(kilometersField.getText());

            // Call backend method to book a taxi
            try {
                String bookingResult = TaxiBooking.booking("Current Location", dropLocation, pickupTime, distanceInKilometers);
                outputArea.setText(bookingResult);
            } catch (CloneNotSupportedException ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        } else if (e.getSource() == displayHistoryButton) {
            // Call backend method to display booking history
            StringBuilder historyResult = new StringBuilder();
            for (Taxi taxi : TaxiBooking.taxiBookedHistory) {
                historyResult.append(taxi.toString()).append("\n-----------------\n");
            }

            outputArea.setText(historyResult.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaxiBookingFrontend frontend = new TaxiBookingFrontend();
            frontend.setVisible(true);
        });
    }
}
