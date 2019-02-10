package com.group8.backspace.objects;


import com.prolificinteractive.materialcalendarview.CalendarDay;

public class Flight {

    private static int nextFlightNum = 1;
    private int flightNum;

    private Location origin;
    private Location destination;

    private CalendarDay departure;
    private CalendarDay arrival;

    public Flight(Location origin, Location destination, CalendarDay departure, CalendarDay arrival) {
        this.flightNum = nextFlightNum;
        nextFlightNum++;

        this.origin = origin;
        this.destination = destination;

        this.departure = departure;
        this.arrival = arrival;
    }

    public int getFlightNum() { return flightNum; }

    public Location getOrigin() { return origin; }

    public Location getDestination() {
        return destination;
    }

    public CalendarDay getDeparture() {
        return departure;
    }

    public CalendarDay getArrival() {
        return arrival;
    }
}
