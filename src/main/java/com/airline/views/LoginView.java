package com.airline.views;

import javax.swing.*;

import com.airline.controllers.UserController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton, employeeLoginButton;

    public LoginView() {
        setTitle("Airline Reservation - Login");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 160, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(20, 100, 100, 25);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(160, 100, 100, 25);
        add(registerButton);

        employeeLoginButton = new JButton("Employee Login");
        employeeLoginButton.setBounds(90, 140, 120, 25);
        add(employeeLoginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (UserController.loginUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new ReservationView().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationView().setVisible(true);
                dispose();
            }
        });

        employeeLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (UserController.loginEmployee(username, password)) {  // Separate method for employee login
                    JOptionPane.showMessageDialog(null, "Employee Login Successful");
                    new EmployeeFlightView().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Employee Credentials");
                }
            }
        });
    }
}
