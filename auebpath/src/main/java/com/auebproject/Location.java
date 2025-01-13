package com.auebproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Location {

    public static void main(String[] args) {
        showLoginPage();
    }

    public static void showLoginPage() {
        JFrame frame = new JFrame("Welcome to the Location App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(getClass().getResource("/images/background.jpg"));
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new CardLayout());

        JPanel loginPanel = createLoginPanel(mainPanel);
        JPanel registerPanel = createRegisterPanel(mainPanel);

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registerPanel, "Register");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static JPanel createLoginPanel(JPanel mainPanel) {
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(getClass().getResource("/images/background.jpg"));
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        loginPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        fieldsPanel.setOpaque(false);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JTextField usernameField = createCustomTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JPasswordField passwordField = createCustomPasswordField();

        JButton loginButton = new JButton("Login");
        styleButton(loginButton);
        JButton registerButton = new JButton("Register");
        styleButton(registerButton);

        fieldsPanel.add(usernameLabel);
        fieldsPanel.add(usernameField);
        fieldsPanel.add(passwordLabel);
        fieldsPanel.add(passwordField);
        loginPanel.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);

        registerButton.setHorizontalAlignment(SwingConstants.LEFT);
        buttonPanel.add(registerButton, BorderLayout.WEST);
        buttonPanel.add(loginButton, BorderLayout.EAST);

        loginPanel.add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                UserDAO userDAO = new UserDAO();
                User user = userDAO.authenticate(username, password);
                JOptionPane.showMessageDialog(loginPanel, "Login successful! Welcome, " + user.getFirstname() + "!");
                SwingUtilities.getWindowAncestor(mainPanel).dispose();
                new Location().location();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(loginPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "Register");
        });

        return loginPanel;
    }

    private static JPanel createRegisterPanel(JPanel mainPanel) {
        JPanel registerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(getClass().getResource("/images/background.jpg"));
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        registerPanel.setLayout(new BorderLayout());
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Register", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        registerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        fieldsPanel.setOpaque(false);

        JLabel firstnameLabel = new JLabel("First Name:");
        firstnameLabel.setForeground(Color.WHITE);
        firstnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JTextField firstnameField = createCustomTextField();

        JLabel lastnameLabel = new JLabel("Last Name:");
        lastnameLabel.setForeground(Color.WHITE);
        lastnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JTextField lastnameField = createCustomTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JTextField emailField = createCustomTextField();

        JLabel usernameLabel = new JLabel("Choose Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JTextField usernameField = createCustomTextField();

        JLabel passwordLabel = new JLabel("Choose Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JPasswordField passwordField = createCustomPasswordField();

        fieldsPanel.add(firstnameLabel);
        fieldsPanel.add(firstnameField);
        fieldsPanel.add(lastnameLabel);
        fieldsPanel.add(lastnameField);
        fieldsPanel.add(emailLabel);
        fieldsPanel.add(emailField);
        fieldsPanel.add(usernameLabel);
        fieldsPanel.add(usernameField);
        fieldsPanel.add(passwordLabel);
        fieldsPanel.add(passwordField);
        registerPanel.add(fieldsPanel, BorderLayout.CENTER);

        JButton registerButton = new JButton("Register");
        styleButton(registerButton);
        JButton backButton = new JButton("Back");
        styleButton(backButton);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);

        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(registerButton, BorderLayout.EAST);

        registerPanel.add(buttonPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();
            String firstname = firstnameField.getText();
            String lastname = lastnameField.getText();

            try {
                UserDAO userDAO = new UserDAO();
                User user = new User(firstname, lastname, email, username, password);
                userDAO.register(user);
                JOptionPane.showMessageDialog(registerPanel, "Registration successful! You can now log in.");
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Login");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(registerPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "Login");
        });

        return registerPanel;
    }

    private static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private static JTextField createCustomTextField() {
        JTextField textField = new JTextField(15);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        textField.setBackground(new Color(240, 248, 255));
        return textField;
    }

    private static JPasswordField createCustomPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        passwordField.setBackground(new Color(240, 248, 255));
        return passwordField;
    }

    public void location() {
        JFrame frame = new JFrame("User Location");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 900); 
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(getClass().getResource("/images/background.jpg"));
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BorderLayout());

        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.setOpaque(false);

        JButton signOutButton = new JButton("Sign Out");
        styleButton(signOutButton);
        signOutButton.setPreferredSize(new Dimension(120, 40)); // Set button size
        signOutButton.addActionListener(e -> {
            frame.dispose();
            showLoginPage();
        });
        topLeftPanel.add(signOutButton);
        mainPanel.add(topLeftPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Enter your current location:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(titleLabel);

        JTextField locationField = createCustomTextField();
        locationField.setMaximumSize(new Dimension(300, 30)); // Set fixed width for the text field
        locationField.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(locationField);

        inputPanel.add(Box.createVerticalStrut(10));

        JButton submitButton = new JButton("Submit");
        styleButton(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(submitButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String location = locationField.getText();
            try {
                Input.inputForGUI(location);
                JOptionPane.showMessageDialog(frame, "Location submitted: " + location);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error processing location: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                showTryAgainScreen();
            }
        });
    }

    private void showTryAgainScreen() {
        JFrame tryAgainFrame = new JFrame("Error");
        tryAgainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tryAgainFrame.setSize(400, 200);
        tryAgainFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel message = new JLabel("An error occurred. Please try again.", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.PLAIN, 16));
        message.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(message);

        panel.add(Box.createVerticalStrut(10));

        JButton retryButton = new JButton("Retry");
        styleButton(retryButton);
        retryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        retryButton.addActionListener(e -> tryAgainFrame.dispose());
        panel.add(retryButton);

        tryAgainFrame.add(panel);
        tryAgainFrame.setVisible(true);
    }
}
