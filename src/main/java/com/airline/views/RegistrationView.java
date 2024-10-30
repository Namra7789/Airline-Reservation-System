package com.airline.views;

import javax.swing.*;

import com.airline.controllers.UserController;
import com.airline.models.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationView extends JFrame {
    private JTextField usernameField, emailField, roleField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegistrationView() {
        setTitle("Airline Reservation - Register");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Username Label and Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 160, 25);
        add(usernameField);


        // Email Label and Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 160, 25);
        add(emailField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 100, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 100, 160, 25);
        add(passwordField);


        // Role Label and Field
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(20, 140, 80, 25);
        add(roleLabel);

        roleField = new JTextField();
        roleField.setBounds(100, 140, 160, 25);
        add(roleField);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 180, 100, 25);
        add(registerButton);


        // Action Listener for Registration
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String email = emailField.getText().trim();
                String role = roleField.getText().trim();

                User newUser = new User(0, username, password, email, role);
                if (UserController.registerUser(newUser)) {
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                    new LoginView().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Failed");
                }
            }
        });
    }
}
