package com.airline.views;

import javax.swing.*;

import com.airline.controllers.ReservationController;
import com.airline.models.Flight;
import com.airline.utils.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationView extends JFrame {
    private JTextField flightNumberField;
    private JButton bookButton, cancelReservationButton;

    public ReservationView() {
        setTitle("Airline Reservation - Book Flight");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberLabel.setBounds(20, 20, 100, 25);
        add(flightNumberLabel);

        flightNumberField = new JTextField();
        flightNumberField.setBounds(130, 20, 140, 25);
        add(flightNumberField);

        bookButton = new JButton("Book Flight");
        bookButton.setBounds(20, 60, 120, 25);
        add(bookButton);

        cancelReservationButton = new JButton("Cancel Reservation");
        cancelReservationButton.setBounds(150, 60, 120, 25);
        add(cancelReservationButton);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNumber = flightNumberField.getText();
                int userId = Session.getUserId();
                if (userId == -1) {
                    JOptionPane.showMessageDialog(null, "Error: User not logged in.");
                    return;
                }
                boolean success = ReservationController.bookFlight( userId,flightNumber);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Flight booked successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Booking failed. Check flight number.");
                }
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CancellationView().setVisible(true);
                dispose();
            }
        });
    }
}
