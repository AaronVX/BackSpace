package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.persistence.FlightPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

    private Flight flight1;
    private Flight flight2;
    private Flight flight3;
    private Flight flight4;

    private List<Flight> storageTest1;

    @Before
    public void setUp() {
        flightPersistence = mock(FlightPersistence.class);
        accessFlights = new AccessFlights(flightPersistence);

        flight1 = new Flight(1, "earth", "venus", new DateTime(1546797600), new DateTime(1546797700));
        flight2 = new Flight(2, "neptune", "venus", new DateTime(1546797600), new DateTime(1546797800));
        flight3 = new Flight(3, "neptune", "venus", new DateTime(1546797600), new DateTime(1546797900));
        flight4 = new Flight(4, "neptune", "venus", new DateTime(1546797600), new DateTime(1546797950));

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
    public void testGetFlights(){
        System.out.println("Start testing GetCurrentFlights");
        when(flightPersistence.getFlights()).thenReturn(storageTest1);
        List<Flight> curr = accessFlights.getFlights();
        assertNotNull(curr);
        assertEquals(curr,storageTest1);
        verify(flightPersistence).getFlights();
        System.out.println("End testing GetFlightByID");
    }

    @Test
    public void testGetCurrentFlights(){
        System.out.println("Start testing GetCurrentFlights");

        when(flightPersistence.getFlights()).thenReturn(storageTest1);

        Random ran = new Random();
        ran = mock(Random.class);
        accessFlights.setRand(ran);
        when(ran.nextInt(17)).thenReturn(0);
        when(ran.nextBoolean()).thenReturn(true);

        accessFlights.setStatusTime(new DateTime(1546797801));

        List<Flight> test = accessFlights.getCurrentFlights();

        //clone storageTest1 and change the status to the specific Flight
        List<Flight> curr = new ArrayList<>();
        curr.add(flight3);
        curr.add(flight4);
        curr.get(0).kill();
        curr.get(1).kill();

        assertNotNull(curr);
        assertEquals(curr,test);
        verify(flightPersistence).getFlights();
        System.out.println("End testing GetFlightByID");
    }

    public List<Flight> cloneList(List<Flight> copy){
        List<Flight> clonedList = new ArrayList<Flight>(copy.size());
        for (Flight flight : copy) {
            clonedList.add(flight);
        }
        return clonedList;
    }


}
