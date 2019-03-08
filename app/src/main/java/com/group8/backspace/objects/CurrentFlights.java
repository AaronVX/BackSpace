package com.group8.backspace.objects;

public class CurrentFlights {

    private int FlightID;
    private String Arrival;
    private double price;
    private String perCentComplete;
    private String status;

    public CurrentFlights(String toArrival, int toFlightID, double toPrice, String toPerCentComplete, String toStatus)
    {
        FlightID = toFlightID;
        Arrival = toArrival;
        price = toPrice;
        perCentComplete = toPerCentComplete;
        status = toStatus;
    }

    public String toString()
    {
        return "Flight: " + FlightID + " will arrive on " + Arrival + " the flight is currently " + perCentComplete + " complete and has " + status + " and the ticket cost: " + price;
    }
}
