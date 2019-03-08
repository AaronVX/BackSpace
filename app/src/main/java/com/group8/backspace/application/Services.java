package com.group8.backspace.application;

import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.PlanetPersistence;
import com.group8.backspace.persistence.ItemPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PlanetPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.ItemPersistenceHSQLDB;
import com.group8.backspace.persistence.stubs.ItemPersistenceStub;
import com.group8.backspace.persistence.stubs.FlightPersistenceStub;

public class Services {

    private static FlightPersistence flightPersistence = null;
    private static PlanetPersistence planetPersistence = null;
    private static ItemPersistence itemPersistence = null;

    private static boolean sql = true;

    public static synchronized  FlightPersistence getFlightPersistence() {
        if (flightPersistence == null) {
            if(sql) {
                flightPersistence = new FlightPersistenceHSQLDB(Main.getDBPathName());
            }
            else{
                flightPersistence = new FlightPersistenceStub();
            }
        }
        return flightPersistence;
    }

    public static synchronized PlanetPersistence getPlanetPersistence() {
        if(planetPersistence == null) {
            if(sql){
                planetPersistence = new PlanetPersistenceHSQLDB(Main.getDBPathName());
            }
            else{
                // TO CHANGE
                planetPersistence = new PlanetPersistenceHSQLDB(Main.getDBPathName());
            }
        }
        return planetPersistence;
    }

    public static synchronized ItemPersistence getItemPersistence() {
        if(itemPersistence == null) {
            if(sql){
                itemPersistence = new ItemPersistenceHSQLDB(Main.getDBPathName());
            }
            else{
                itemPersistence = new ItemPersistenceStub();
            }
        }
        return itemPersistence;
    }

}
