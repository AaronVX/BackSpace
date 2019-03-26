package com.group8.backspace.IntegrationTests;


import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessFlightsIT {
    private AccessFlights accessFlights;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final FlightPersistence persistence = new FlightPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessFlights = new AccessFlights(persistence);
    }

    @Test
    public void testGetFlightByID(){
        final Flight flight;
        flight = accessFlights.getFlightByID(37);
        assertNotNull("The flight #37 should not be null", flight);
        assertTrue("jupiter".equals(flight.getOrigin()));

        System.out.println("End testing GetFlightByID");
    }
}
