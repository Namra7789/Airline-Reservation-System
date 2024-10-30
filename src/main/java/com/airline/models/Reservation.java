package com.airline.models;

public class Reservation {
    private int id;
    private String flightNumber;
    private int userId;
    private int flightId;
    private String status;
    

    public Reservation() {}

    public Reservation(int id,String flightNumber, int userId, int flightId, String status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.userId = userId;
        this.flightId = flightId;
        this.status = status;
        
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getFlightId() { return flightId; }
    public void setFlightId(int flightId) { this.flightId = flightId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    

}
