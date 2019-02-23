package com.group8.backspace.objects;


import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.Date;

public class Flight {

    private int flightID;

    private String origin;
    private String destination;

    private Date departure;
    private Date arrival;

    //private int ticketPrice;

    public Flight(int flightID, String origin, String destination, Date departure, Date arrival) {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;

        this.departure = departure;
        this.arrival = arrival;
        //this.ticketPrice = ticketPrice;
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

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }
}
