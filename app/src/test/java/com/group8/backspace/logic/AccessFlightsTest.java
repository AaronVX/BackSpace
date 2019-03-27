package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.persistence.FlightPersistence;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.joda.time.DateTime;

public class AccessFlightsTest {

    private AccessFlights accessFlights;
    private FlightPersistence flightPersistence;

    private ArrayList <Flight> storageTest1;

    Flight flight1;
    Flight flight2;
    Flight flight3;
    Flight flight4;


    @Before
    public void setUp() {
        flightPersistence = mock(FlightPersistence.class);
        accessFlights = new AccessFlights(flightPersistence);

        flight1 = new Flight(1, "earth", "venus", new DateTime(1546797600), new DateTime(1546797600));
        flight2 = new Flight(2, "neptune", "venus", new DateTime(1546538400), new DateTime(1546538400));
        flight3 = new Flight(3, "neptune", "venus", new DateTime(1547316000), new DateTime(1547316000));
        flight4 = new Flight(4, "neptune", "venus", new DateTime(1556125200), new DateTime(1556125200));

        storageTest1 = new ArrayList<>();
        storageTest1.add(flight1);
        storageTest1.add(flight2);
        storageTest1.add(flight3);
        storageTest1.add(flight4);

    }

    @Test
    public void testNull() {
        System.out.println("Start testing null");
        assertNotNull(accessFlights);
        assertNotNull(accessFlights.getFlights());
//        assertNotNull(accessFlights.getCurrentFlights());
        System.out.println("End testing null");
    }

    @Test
    public void testGetFlightByID(){
        System.out.println("Start testing GetFlightByID");
        when(flightPersistence.getFlightByID(1)).thenReturn(flight1);
        Flight test1 = accessFlights.getFlightByID(1);
        assertNotNull(test1);
        assertEquals(test1,flight1);

        verify(flightPersistence).getFlightByID(1);
        System.out.println("End testing GetFlightByID");
    }

    @Test
    public void testGetCurrentFlights(){
        System.out.println("Start testing GetCurrentFlights");
        ArrayList<Flight>currFlights = new ArrayList<>();


    }


}
