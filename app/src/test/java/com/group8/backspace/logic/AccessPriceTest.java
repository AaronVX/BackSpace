package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.persistence.FlightPersistence;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class AccessPriceTest {
    private AccessFlights accessFlights;
    private FlightPersistence flightPersistence;

    private Flight flight;

    @Before
    public void setUp(){
        flightPersistence = mock(FlightPersistence.class);
        accessFlights = new AccessFlights(flightPersistence);

        flight = new Flight(1, "earth", "venus", new DateTime(1546797600), new DateTime(1546797700));
    }

    @Test
    public void
}
