package com.group8.backspace.logic;

import com.group8.backspace.application.Services;
import com.group8.backspace.objects.CurrentFlights;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.CurrentFlightsPersistence;
import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.hsqldb.CurrentFlightsPersistenceHSQLDB;

import java.util.Collections;
import java.util.List;

public class AccessFlights {

    FlightPersistence flightPersistence;
    CurrentFlightsPersistence cfp;

    public AccessFlights() {
        flightPersistence = Services.getFlightPersistence();
        cfp = Services.getCurrentFlightPersistence();
    }

    /*
    public List<Flight> getCurrentFlights() {
        return Collections.unmodifiableList(flightPersistence.getCurrentFlights());
    }

    public List<Flight> getCurrentFlights(Location origin, Location destination) {
        return Collections.unmodifiableList(flightPersistence.getCurrentFlights(origin, destination));
    }

    public List<Flight> getFutureFlights() {
        return Collections.unmodifiableList(flightPersistence.getFutureFlights());
    }
    */

    public List<Flight> getFutureFlights(Location origin, Location destination) {
        return Collections.unmodifiableList(flightPersistence.getFutureFlights(origin,destination));
    }

    public Flight getFlightByNum(int searchFlightNum) {
        return flightPersistence.getFlightByNum(searchFlightNum);
    }

    public List<CurrentFlights> getAllInfo () {
        return cfp.getInfo();
    }

}
