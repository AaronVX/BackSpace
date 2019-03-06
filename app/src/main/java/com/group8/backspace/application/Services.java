package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.PlanetPersistence;
import com.group8.backspace.persistence.ItemPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PlanetPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.ItemPersistenceHSQLDB;
import com.group8.backspace.persistence.stubs.ItemPersistenceStub;

public class Services {

    private static FlightPersistence flightPersistence = null;
    private static PlanetPersistence planetPersistence = null;
    private static ItemPersistence itemPersistence = null;

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

    public static synchronized ItemPersistence getItemPersistence() {
        if(itemPersistence == null) {
//            itemPersistence = new ItemPersistenceStub();
            itemPersistence = new ItemPersistenceHSQLDB(Main.getDBPathName());
        }
        return itemPersistence;
    }

}
