package com.airline.services;

import java.sql.*;

import com.airline.database.DatabaseConnection;
import com.airline.models.Reservation;

public class ReservationService {
    public Reservation findReservationById(int reservationId) {
        String sql = "SELECT * FROM reservations WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reservationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Reservation(
                    resultSet.getInt("id"),
                    resultSet.getString("flight_number"),
                    resultSet.getInt("user_id"),
                    resultSet.getInt("flight_id"),
                    resultSet.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (flight_id, user_id, status) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, reservation.getFlightId());
            preparedStatement.setInt(2, reservation.getUserId());
            preparedStatement.setString(3, reservation.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(int reservationId) {
        String sql = "DELETE FROM reservations WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reservationId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}