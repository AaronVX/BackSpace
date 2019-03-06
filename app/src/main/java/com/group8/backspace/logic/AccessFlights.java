package com.group8.backspace.logic;

import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.FlightPersistence;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessFlights {

    FlightPersistence flightPersistence;

    public AccessFlights() {
        flightPersistence = Services.getFlightPersistence();
    }

    public List<Flight> getFlights() {
        return Collections.unmodifiableList(flightPersistence.getFlights());
    }

    public AccessFlights(final FlightPersistence flightPersistence){
        this();
        this.flightPersistence = flightPersistence;
    }

    public List<Flight> getFlights(String origin, String destination) {
        return Collections.unmodifiableList(flightPersistence.getFlights(origin, destination));
    }



    public List<Flight> getCurrentFlights() {
        ArrayList<Flight> futureFlights = new ArrayList<>();
        List<Flight> flights = flightPersistence.getFlights();
        DateTime now = DateTime.now();

        for (Flight flight : flights) {
            if (flight.getDeparture().compareTo(now) < 0) {
                futureFlights.add(flight);
            }
        }

        return Collections.unmodifiableList(flights);
    }

    public List<Flight> getCurrentFlights(String origin, String destination) {
        ArrayList<Flight> futureFlights = new ArrayList<>();
        List<Flight> flights = flightPersistence.getFlights();
        DateTime now = DateTime.now();

        for (Flight flight : flights) {
            if (flight.getDeparture().compareTo(now) < 0) {
                futureFlights.add(flight);
            }
        }

        return Collections.unmodifiableList(flights);
    }


    public List<Flight> getFutureFlights() {
        ArrayList<Flight> futureFlights = new ArrayList<>();
        List<Flight> flights = flightPersistence.getFlights();
        DateTime now = DateTime.now();

        for (Flight flight : flights) {
            if (flight.getDeparture().compareTo(now) > 0) {
                futureFlights.add(flight);
            }
        }

        return Collections.unmodifiableList(flights);
    }

    public List<Flight> getFutureFlights(String origin, String destination) {
        ArrayList<Flight> futureFlights = new ArrayList<>();
        List<Flight> flights = flightPersistence.getFlights(origin, destination);
        DateTime now = DateTime.now();

        for (Flight flight : flights) {
            if (flight.getDeparture().compareTo(now) > 0) {
                futureFlights.add(flight);
            }
        }

        return Collections.unmodifiableList(flights);
    }

    public Flight getFlightByID(int searchFlightNum) {
        return flightPersistence.getFlightByID(searchFlightNum);
    }
}
