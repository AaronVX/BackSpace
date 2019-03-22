package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.ItemPersistence;
import com.group8.backspace.persistence.PlanetPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.ItemPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PlanetPersistenceHSQLDB;



public class Services {

    final static boolean HSQLDB = true; //This boolean is used to swap between the stub db and HSQLDB

    private static FlightPersistence flightPersistence = null;
    private static PlanetPersistence planetPersistence = null;
    private static ItemPersistence itemPersistence = null;

    public static synchronized  FlightPersistence getFlightPersistence() {
        if (flightPersistence == null) {
            if (HSQLDB)
                flightPersistence = new FlightPersistenceHSQLDB(Main.getDBPathName());
        }
        return flightPersistence;
    }

    public static synchronized PlanetPersistence getPlanetPersistence() {
        if(planetPersistence == null) {
            if(HSQLDB)
                planetPersistence = new PlanetPersistenceHSQLDB(Main.getDBPathName());

        }
        return planetPersistence;
    }

    public static synchronized ItemPersistence getItemPersistence() {
        if(itemPersistence == null) {
            if(HSQLDB)
                itemPersistence = new ItemPersistenceHSQLDB(Main.getDBPathName());
        }
        return itemPersistence;
    }

}
