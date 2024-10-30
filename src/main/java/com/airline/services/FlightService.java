package com.airline.services;

import java.sql.*;

import com.airline.database.DatabaseConnection;
import com.airline.models.Flight;

public class FlightService {
    public Flight findFlightByNumber(String flightNumber) {
        String sql = "SELECT * FROM flights WHERE flight_number = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, flightNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Flight(
                    resultSet.getInt("id"),
                    resultSet.getString("flight_number"),
                    resultSet.getString("departure"),
                    resultSet.getString("destination"),
                    resultSet.getTimestamp("time"),
                    resultSet.getInt("available_seats")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAvailableSeats(String flightNumber, int newSeatCount) {
        String sql = "UPDATE flights SET available_seats = ? WHERE flight_number = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newSeatCount);
            preparedStatement.setString(2, flightNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveOrUpdateFlight(Flight flight) {
        String checkFlightSql = "SELECT id FROM flights WHERE flight_number = ?";
        String insertFlightSql = "INSERT INTO flights (flight_number, departure, destination, time, available_seats) VALUES (?, ?, ?, ?, ?)";
        String updateFlightSql = "UPDATE flights SET departure = ?, destination = ?, time = ?, available_seats = ? WHERE flight_number = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);  // Disable auto-commit for transaction management

            try (PreparedStatement checkStatement = connection.prepareStatement(checkFlightSql)) {
                checkStatement.setString(1, flight.getFlightNumber());
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    // Flight exists, perform an update
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateFlightSql)) {
                        updateStatement.setString(1, flight.getDeparture());
                        updateStatement.setString(2, flight.getDestination());
                        updateStatement.setTimestamp(3, flight.getTime());
                        updateStatement.setInt(4, flight.getAvailableSeats());
                        updateStatement.setString(5, flight.getFlightNumber());

                        int rowsAffected = updateStatement.executeUpdate();
                        connection.commit();  // Commit after successful update
                        return rowsAffected > 0;
                    }
                } else {
                    // Flight does not exist, perform an insert
                    try (PreparedStatement insertStatement = connection.prepareStatement(insertFlightSql)) {
                        insertStatement.setString(1, flight.getFlightNumber());
                        insertStatement.setString(2, flight.getDeparture());
                        insertStatement.setString(3, flight.getDestination());
                        insertStatement.setTimestamp(4, flight.getTime());
                        insertStatement.setInt(5, flight.getAvailableSeats());

                        int rowsAffected = insertStatement.executeUpdate();
                        connection.commit();  // Commit after successful insert
                        return rowsAffected > 0;
                    }
                }
            } catch (SQLException e) {
                connection.rollback();  // Rollback on failure
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
