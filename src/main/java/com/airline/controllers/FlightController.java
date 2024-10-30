package com.airline.controllers;

import java.sql.Timestamp;

import com.airline.models.Flight;
import com.airline.services.FlightService;

public class FlightController {
    private static FlightService flightService = new FlightService();

    public static boolean addFlight(int id, String flightNumber, String departure, String destination, Timestamp time, int availableSeats) {
        if (flightService.findFlightByNumber(flightNumber) == null) {
            Flight flight = new Flight(id, flightNumber, departure, destination, time, availableSeats);
            flightService.saveOrUpdateFlight(flight);
            return true;
        }
        return false;
    }

    public static Flight getFlightDetails(String flightNumber) {
        return flightService.findFlightByNumber(flightNumber);
    }

    public static boolean updateFlight(Flight flight) {
        // Validate that the flight object is not null and has required fields
        if (flight != null && flight.getFlightNumber() != null && !flight.getFlightNumber().isEmpty()) {
            return flightService.saveOrUpdateFlight(flight);
        }
        return false;
    }
}
