import javax.swing.*;
import java.awt.*;

public class Location {
    public static void main(String[] args) {
        // Δημιουργία του αρχικού παραθύρου
        JFrame frame = new JFrame("Τοποθεσία Χρήστη");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        // Δημιουργία κεντρικού panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Δημιουργία του JPanel με φόντο εικόνας (στο κέντρο)
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Φόρτωση της εικόνας
                ImageIcon backgroundImage = new ImageIcon("background.jpg");
                int x = (getWidth() - backgroundImage.getIconWidth()) / 2; // Κεντρική στο X
                int y = (getHeight() - backgroundImage.getIconHeight()) / 2; // Κεντρική στο Y
                g.drawImage(backgroundImage.getImage(), x, y, this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(400, 250)); // Ορίζει το μέγεθος της εικόνας
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Ετικέτα κάτω από την εικόνα με ανοιχτό λαχανί φόντο
        JLabel messageLabel = new JLabel("Πληκτρολογήστε πού είστε:");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(245, 245, 220)); // Ανοιχτό λαχανί χρώμα
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Περιθώρια γύρω από το κείμενο
        mainPanel.add(messageLabel, BorderLayout.NORTH);

        // Δημιουργία πάνελ για πεδίο κειμένου και κουμπί (κάτω από την εικόνα)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setPreferredSize(new Dimension(400, 200));

        // Πεδίο κειμένου
        JTextField textField = new JTextField();
        textField.setMargin(new Insets(10, 10, 10, 10)); // Αφή στα πλαϊνά
        inputPanel.add(textField, BorderLayout.CENTER);

        // Κουμπί υποβολής με έντονο γαλάζιο χρώμα
        JButton submitButton = new JButton("Υποβολή");
        submitButton.setBackground(new Color(51, 153, 255)); // Γαλάζιο
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(submitButton, BorderLayout.SOUTH);

        // Ενέργεια όταν ο χρήστης πατήσει το κουμπί υποβολής
        submitButton.addActionListener(e -> {
            String location = textField.getText();
            frame.dispose(); // Κλείνει το αρχικό παράθυρο
            openDestinationWindow(location); // Καλεί το νέο παράθυρο
        });

        // Προσθήκη πάνελ στο κύριο παράθυρο
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Προσθήκη του κύριου panel στο JFrame
        frame.setContentPane(mainPanel);

        // Εμφάνιση του παραθύρου
        frame.setVisible(true);
    }

    // Μέθοδος για το άνοιγμα νέου παραθύρου
    public static void openDestinationWindow(String currentLocation) {
        // Δημιουργία του νέου παραθύρου
        JFrame destinationFrame = new JFrame("Νέα Τοποθεσία");
        destinationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        destinationFrame.setSize(400, 500);

        // Δημιουργία κεντρικού panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Δημιουργία του JPanel με φόντο εικόνας (στο κέντρο)
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Φόρτωση της εικόνας
                ImageIcon backgroundImage = new ImageIcon("background.jpg");
                int x = (getWidth() - backgroundImage.getIconWidth()) / 2; // Κεντρική στο X
                int y = (getHeight() - backgroundImage.getIconHeight()) / 2; // Κεντρική στο Y
                g.drawImage(backgroundImage.getImage(), x, y, this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(400, 250)); // Ορίζει το μέγεθος της εικόνας
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Ετικέτα κάτω από την εικόνα με ανοιχτό λαχανί φόντο
        JLabel messageLabel = new JLabel("Πληκτρολογήστε πού θέλετε να πάτε:");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(245, 245, 220)); // Ανοιχτό λαχανί χρώμα
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Περιθώρια γύρω από το κείμενο
        mainPanel.add(messageLabel, BorderLayout.NORTH);

        // Δημιουργία πάνελ για πεδίο κειμένου και κουμπί (κάτω από την εικόνα)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setPreferredSize(new Dimension(400, 200));

        // Πεδίο κειμένου
        JTextField textField = new JTextField();
        textField.setMargin(new Insets(10, 10, 10, 10)); // Αφή στα πλαϊνά
        inputPanel.add(textField, BorderLayout.CENTER);

        // Κουμπί υποβολής με έντονο γαλάζιο χρώμα
        JButton submitButton = new JButton("Υποβολή");
        submitButton.setBackground(new Color(51, 153, 255)); // Γαλάζιο
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(submitButton, BorderLayout.SOUTH);

        // Ενέργεια όταν ο χρήστης πατήσει το κουμπί υποβολής
        submitButton.addActionListener(e -> {
            String destination = textField.getText();
            JOptionPane.showMessageDialog(destinationFrame, "Από: " + currentLocation + "\nΠρος: " + destination);
        });

        // Προσθήκη πάνελ στο κύριο παράθυρο
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Προσθήκη του κύριου panel στο JFrame
        destinationFrame.setContentPane(mainPanel);

        // Εμφάνιση του νέου παραθύρου
        destinationFrame.setVisible(true);
    }
}

