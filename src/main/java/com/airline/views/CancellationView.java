package com.airline.views;

import javax.swing.*;

import com.airline.controllers.ReservationController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancellationView extends JFrame {
    private JTextField reservationIdField;
    private JButton cancelButton;

    public CancellationView() {
        setTitle("Airline Reservation - Cancel Reservation");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel reservationIdLabel = new JLabel("Reservation ID:");
        reservationIdLabel.setBounds(20, 20, 100, 25);
        add(reservationIdLabel);

        reservationIdField = new JTextField();
        reservationIdField.setBounds(130, 20, 140, 25);
        add(reservationIdField);

        cancelButton = new JButton("Cancel Reservation");
        cancelButton.setBounds(80, 70, 150, 25);
        add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reservationId = Integer.parseInt(reservationIdField.getText());
                boolean success = ReservationController.cancelReservation(reservationId);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Reservation cancelled successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cancellation failed. Check reservation ID.");
                }
            }
        });
    }
}
