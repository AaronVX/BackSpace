package com.group8.backspace.persistence;

import com.group8.backspace.persistence.stubs.FlightPersistenceStub;

public class Services {

    private static FlightPersistence flightPersistence = null;


    public static synchronized  FlightPersistence getFlightPersistence() {
        if (flightPersistence == null) {
            flightPersistence = new FlightPersistenceStub();
        }
        return flightPersistence;
    }
}
