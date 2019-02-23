package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;

public class Services {

    private static FlightPersistence flightPersistence = null;

    public static synchronized  FlightPersistence getFlightPersistence() {
        if (flightPersistence == null) {
            flightPersistence = new FlightPersistenceHSQLDB(Main.getDBPathName());
            //flightPersistence = new FlightPersistenceStub();
        }
        return flightPersistence;
    }

}
