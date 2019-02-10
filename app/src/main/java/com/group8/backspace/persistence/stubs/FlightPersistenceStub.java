package com.group8.backspace.persistence.stubs;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.FlightPersistence;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightPersistenceStub implements FlightPersistence {

    List<Flight> flights;

    public FlightPersistenceStub(){
        flights = new ArrayList<Flight>();

        Flight flight1 = new Flight(Location.EARTH, Location.VENUS, CalendarDay.from(2019,2,14), CalendarDay.from(2019,5,20), 1000);
        Flight flight2 = new Flight(Location.EARTH, Location.VENUS, CalendarDay.from(2019,2,20), CalendarDay.from(2019,5,20), 1000);
        flights.add(flight1);
        flights.add(flight2);
    }

    @Override
    public List<Flight> getCurrentFlights() {
        ArrayList<Flight> currentFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().isBefore(CalendarDay.today())) {
                currentFlights.add(flight);
            }
        }
        return currentFlights;
    }

    @Override
    public List<Flight> getCurrentFlights(Location origin, Location destination) {
        ArrayList<Flight> currentFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().isBefore(CalendarDay.today()) && flight.getOrigin() == origin && flight.getDestination() == destination) {
                currentFlights.add(flight);
            }
        }
        return currentFlights;

    }

    @Override
    public List<Flight> getFutureFlights() {
        ArrayList<Flight> currentFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().isAfter(CalendarDay.today())) {
                currentFlights.add(flight);
            }
        }
        return currentFlights;

    }

    @Override
    public List<Flight> getFutureFlights(Location origin, Location destination) {
        ArrayList<Flight> currentFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().isAfter(CalendarDay.today()) && flight.getOrigin() == origin && flight.getDestination() == destination) {
                currentFlights.add(flight);
            }
        }
        return currentFlights;

    }

    @Override
    public Flight getFlightByNum(int flightSearchNum ) {
        Flight foundFlight = null;
        for(Flight flight : flights) {
            if(flight.getFlightNum() == flightSearchNum ) {
                foundFlight = flight;
            }
        }
        return foundFlight;

    }

}