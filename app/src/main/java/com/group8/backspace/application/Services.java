package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.PlanetPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PlanetPersistenceHSQLDB;

public class Services {

    private static FlightPersistence flightPersistence = null;
    private static PlanetPersistence planetPersistence = null;

    public static synchronized  FlightPersistence getFlightPersistence() {
        if (flightPersistence == null) {
            flightPersistence = new FlightPersistenceHSQLDB(Main.getDBPathName());

            //flightPersistence = new FlightPersistenceStub();
        }
        return flightPersistence;
    }

    public static synchronized PlanetPersistence getPlanetPersistence() {
        if(planetPersistence == null) {
            planetPersistence = new PlanetPersistenceHSQLDB(Main.getDBPathName());

        }
        return planetPersistence;
    }

}
