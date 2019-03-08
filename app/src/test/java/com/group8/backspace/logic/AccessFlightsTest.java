package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.persistence.stubs.FlightPersistenceStub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessFlightsTest {

    private AccessFlights accessFlights;

    @Before
    public void setUp() {accessFlights = new AccessFlights(new FlightPersistenceStub()); }

    @Test
    public void test1() {
        final Flight flight;
        System.out.println("\nStarting test AccessFlights");

        flight = accessFlights.getFlightByID(1);
        assertNotNull("first flight should not be null", flight);
        assertTrue("earth".equals(flight.getOrigin()));

        System.out.println("Finished test AccessFlights");
    }

}
