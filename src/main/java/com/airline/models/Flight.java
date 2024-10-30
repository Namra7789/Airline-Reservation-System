package com.airline.models;

import java.sql.Timestamp;

public class Flight {
    private int id;
    private String flightNumber;
    private String departure;
    private String destination;
    private Timestamp time;
    private int availableSeats;

    public Flight() {}

    public Flight(int id, String flightNumber, String departure, String destination, Timestamp time,int availableSeats) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getDeparture() { return departure; }
    public void setDeparture(String departure) { this.departure = departure; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Timestamp getTime() { return time; }
    public void setTime(Timestamp time) { this.time = time; }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
