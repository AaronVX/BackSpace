package com.group8.backspace.objects;


import com.prolificinteractive.materialcalendarview.CalendarDay;

public class Flight {

    private Location origin;
    private Location destination;

    private CalendarDay departure;
    private CalendarDay arrival;

    public Flight(Location origin, Location destination, CalendarDay departure, CalendarDay arrival) {
        this.origin = origin;
        this.destination = destination;

        this.departure = departure;
        this.arrival = arrival;
    }

    public Location getOrigin() {
        return origin;
    }

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
