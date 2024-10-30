package com.airline.controllers;

import com.airline.models.Flight;
import com.airline.models.Reservation;
import com.airline.services.FlightService;
import com.airline.services.ReservationService;

public class ReservationController {
    private static FlightService flightService = new FlightService();
    private static ReservationService reservationService = new ReservationService();

    public static boolean bookFlight(int userId, String flightNumber) {
        Flight flight = flightService.findFlightByNumber(flightNumber);
        if (flight != null && flight.getAvailableSeats() > 0) {
            int flightId = flight.getId();
            String status = "Booked";
            Reservation reservation = new Reservation(0, flightNumber, userId, flightId, status);
            reservationService.saveReservation(reservation);
            flightService.updateAvailableSeats(flightNumber, flight.getAvailableSeats() - 1);
            return true;
        }
        return false;
    }

    public static boolean cancelReservation(int reservationId) {
        Reservation reservation = reservationService.findReservationById(reservationId);
        if (reservation != null) {
            reservationService.deleteReservation(reservationId);
            flightService.updateAvailableSeats(reservation.getFlightNumber(),
                    flightService.findFlightByNumber(reservation.getFlightNumber()).getAvailableSeats() + 1);
            return true;
        }
        return false;
    }
}
