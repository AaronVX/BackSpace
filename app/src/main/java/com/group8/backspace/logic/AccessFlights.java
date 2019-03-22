package com.group8.backspace.logic;

import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.presentation.PurchaseTicket.DateHandler;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AccessFlights {

    FlightPersistence flightPersistence;

    public AccessFlights() {
        flightPersistence = Services.getFlightPersistence();
    }

    public List<Flight> getFlights() { return Collections.unmodifiableList(flightPersistence.getFlights()); }

    public AccessFlights(final FlightPersistence flightPersistence) {
        this();
        this.flightPersistence = flightPersistence;
    }

    public List<Flight> getCurrentFlights() {
        ArrayList<Flight> futureFlights = new ArrayList<>();
        List<Flight> flights = flightPersistence.getFlights();
        DateTime now = DateTime.now();
        Random rand = new Random();

        for (Flight flight : flights) {
            if (flight.getDeparture().compareTo(now) < 0) {
                if(flight.getStatus() == null) {
                    String newStatus = "Status: ";
                    int isDead = rand.nextInt(17);
                    boolean onTime = rand.nextBoolean();
                    if (isDead == 0) {
                        newStatus = "Status: Crew Dead\nFlight Stage: Failure\nETA: Unknown";
                    } else {
                        if (onTime) {
                            newStatus += "On Time\nFlight Stage: ";
                        } else {
                            newStatus += "Delayed\nFlight Stage: ";
                        }
                        DateTime depart = flight.getDeparture();
                        DateTime eta = flight.getArrival();
                        DateHandler dateHandle = new DateHandler(depart, eta);
                        String etaString = dateHandle.getStrings()[1];

                        long quarterTime = (eta.getMillis() - depart.getMillis()) / 4;
                        if ((quarterTime + depart.getMillis()) > now.getMillis()) {    //just leaving
                            newStatus += "Leaving Orbit\nETA: " + etaString;
                        } else if ((eta.getMillis() - quarterTime) < now.getMillis()) {   //just arriving
                            newStatus += "Deorbiting\nETA: " + etaString;
                        } else {       //in the middle of the journey
                            newStatus += "In Transfer\nETA: " + etaString;
                        }
                    }
                    flight.setStatus(newStatus);
                }
                futureFlights.add(flight);
            }
        }
        return Collections.unmodifiableList(futureFlights);
    }

    public List<Flight> getFutureFlights(String origin, String destination){
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

    public Flight getFlightByID(int searchFlightNum) { return flightPersistence.getFlightByID(searchFlightNum); }

}
