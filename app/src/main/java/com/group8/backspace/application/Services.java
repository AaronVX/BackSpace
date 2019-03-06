package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.PlanetPersistence;
import com.group8.backspace.persistence.PricePersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PlanetPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PricePersistenceHSQLDB;
import com.group8.backspace.persistence.stubs.PricePersistenceStub;

public class Services {

    private static FlightPersistence flightPersistence = null;
    private static PlanetPersistence planetPersistence = null;
    private static PricePersistence pricePersistence = null;

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

    public static synchronized PricePersistence getPricePersistence() {
        if(pricePersistence == null) {
            //pricePersistence = new PricePersistenceStub();
            pricePersistence = new PricePersistenceHSQLDB(Main.getDBPathName());
        }
        return pricePersistence;
    }

}
