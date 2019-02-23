package com.group8.backspace.persistence;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;

import java.util.List;

public interface FlightPersistence {
    List<Flight> getFlights();
    List<Flight> getFlights(String origin, String destination);

    Flight getFlightByID(int flightID);

}
