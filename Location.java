import javax.swing.*;
import java.awt.*;

public class Location {
    public static void main(String[] args) {
        // Δημιουργία του αρχικού παραθύρου
        JFrame frame = new JFrame("Τοποθεσία Χρήστη");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Δημιουργία ετικέτας με το μήνυμα
        JLabel label = new JLabel("Πληκτρολογήστε την τοποθεσία σας:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        // Δημιουργία πεδίου κειμένου όπου ο χρήστης μπορεί να πληκτρολογήσει
        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.CENTER);

        // Δημιουργία κουμπιού υποβολής
        JButton submitButton = new JButton("Υποβολή");
        frame.add(submitButton, BorderLayout.SOUTH);

        // Ενέργεια όταν ο χρήστης πατήσει το κουμπί υποβολής
        submitButton.addActionListener(e -> {
            String location = textField.getText();
            frame.dispose(); // Κλείνει το αρχικό παράθυρο
            openDestinationWindow(location); // Καλεί το νέο παράθυρο
        });

        // Εμφάνιση του παραθύρου
        frame.setVisible(true);
    }

    // Μέθοδος για το άνοιγμα νέου παραθύρου
    public static void openDestinationWindow(String currentLocation) {
        // Δημιουργία του νέου παραθύρου
        JFrame destinationFrame = new JFrame("Νέα Τοποθεσία");
        destinationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        destinationFrame.setSize(400, 200);
        destinationFrame.setLayout(new BorderLayout());

        // Ετικέτα με το μήνυμα για την επιθυμητή τοποθεσία
        JLabel destinationLabel = new JLabel("Πληκτρολογήστε την τοποθεσία που επιθυμείτε να πάτε:");
        destinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        destinationFrame.add(destinationLabel, BorderLayout.NORTH);

        // Πεδίο κειμένου για την επιθυμητή τοποθεσία
        JTextField destinationField = new JTextField();
        destinationFrame.add(destinationField, BorderLayout.CENTER);

        // Κουμπί υποβολής
        JButton destinationSubmitButton = new JButton("Υποβολή");
        destinationFrame.add(destinationSubmitButton, BorderLayout.SOUTH);

        // Ενέργεια όταν ο χρήστης πατήσει το κουμπί υποβολής στο νέο παράθυρο
        destinationSubmitButton.addActionListener(e -> {
            String destination = destinationField.getText();
            JOptionPane.showMessageDialog(destinationFrame, "Από: " + currentLocation + "\nΠρος: " + destination);
        });

        // Εμφάνιση του νέου παραθύρου
        destinationFrame.setVisible(true);
    }
}