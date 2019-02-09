package com.group8.backspace.persistence;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;

import java.util.List;

public interface FlightPersistence {
    List<Flight> getCurrentFlights();
    List<Flight> getCurrentFlights(Location origin, Location destination);

    List<Flight> getFutureFlights();
    List<Flight> getFutureFlights(Location origin, Location destination);

}
