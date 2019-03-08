package com.group8.backspace.objects;

import org.joda.time.DateTime;


public class Flight {

    private int flightID;

    private String origin;
    private String destination;

    private DateTime departure;
    private DateTime arrival;

    private String status;

    public Flight(int flightID, String origin, String destination, DateTime departure, DateTime arrival)
    {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;

        this.departure = departure;
        this.arrival = arrival;
    }

    public int getFlightID() {
        return flightID;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public DateTime getDeparture() {
        return departure;
    }

    public DateTime getArrival() {
        return arrival;
    }

    public String getStatus(){ return status; }
    public void setStatus( String newStat ){ status = newStat; }

}
