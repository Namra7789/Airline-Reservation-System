package com.airline.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.airline.controllers.FlightController;
import com.airline.models.Flight;

public class EmployeeFlightView extends JFrame {
    private JTextField flightNumberField;
    private JTextField departureField;
    private JTextField destinationField;
    private JTextField timeField;
    private JTextField seatsField;
    private JButton updateButton;

    public EmployeeFlightView() {
        setTitle("Airline Employee - Update Flight Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberLabel.setBounds(20, 20, 120, 25);
        add(flightNumberLabel);

        flightNumberField = new JTextField();
        flightNumberField.setBounds(150, 20, 200, 25);
        add(flightNumberField);

        JLabel departureLabel = new JLabel("Departure:");
        departureLabel.setBounds(20, 60, 120, 25);
        add(departureLabel);

        departureField = new JTextField();
        departureField.setBounds(150, 60, 200, 25);
        add(departureField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(20, 100, 120, 25);
        add(destinationLabel);

        destinationField = new JTextField();
        destinationField.setBounds(150, 100, 200, 25);
        add(destinationField);

        JLabel timeLabel = new JLabel("Departure Time (yyyy-MM-dd HH:mm:ss):");
        timeLabel.setBounds(20, 140, 250, 25);
        add(timeLabel);

        timeField = new JTextField();
        timeField.setBounds(150, 170, 200, 25);
        add(timeField);

        JLabel seatsLabel = new JLabel("Available Seats:");
        seatsLabel.setBounds(20, 210, 120, 25);
        add(seatsLabel);

        seatsField = new JTextField();
        seatsField.setBounds(150, 210, 200, 25);
        add(seatsField);

        updateButton = new JButton("Update Flight");
        updateButton.setBounds(150, 250, 150, 25);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String flightNumber = flightNumberField.getText();
                    String departure = departureField.getText();
                    String destination = destinationField.getText();
                    Timestamp departureTime = Timestamp.valueOf(timeField.getText());
                    int availableSeats = Integer.parseInt(seatsField.getText());

                    Flight flight = new Flight(0, flightNumber, departure, destination, departureTime, availableSeats);

                    if (FlightController.updateFlight(flight)) {
                        JOptionPane.showMessageDialog(null, "Flight details updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please check all fields and try again.");
                    ex.printStackTrace();
                }
            }
        });
    }
}
