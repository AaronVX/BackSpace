package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.stubs.FlightPersistenceStub;

import com.group8.backspace.persistence.hsqldb.CurrentFlightsPersistenceHSQLDB;
import com.group8.backspace.persistence.CurrentFlightsPersistence;

public class Services {

    private static FlightPersistence flightPersistence = null;
    private static CurrentFlightsPersistence currentFlightsPersistence = null;


    // need to merge these 2 methods later ..

    public static synchronized  CurrentFlightsPersistence getCurrentFlightPersistence() {
        if (currentFlightsPersistence == null) {
            currentFlightsPersistence = new CurrentFlightsPersistenceHSQLDB(Main.getDBPathName());
        }
        return currentFlightsPersistence;
    }

    public static synchronized FlightPersistence getFlightPersistence() {
        if (flightPersistence == null) {
            flightPersistence = new FlightPersistenceStub();
        }
        return flightPersistence;
    }

}
