package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;

import com.group8.backspace.persistence.PlanetPersistence;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

public class AnalyseFlightTest {
    private PlanetPersistence planetPersistence;
    private AnalyseFlight analyseFlight;
    private Flight flight;

    private Location origin;
    private Location destination;

    @Before
    public void setUp(){
        planetPersistence = mock(PlanetPersistence.class);
        flight = new Flight(1, "earth", "venus", new DateTime(1546797600), new DateTime(1546797700));
        analyseFlight = new AnalyseFlight(flight,planetPersistence);

        origin = new Location ("1");
        origin.setDistance("10");
        destination = new Location("2");
        destination.setDistance("20");

    }
    @Test
    public void testNull() {
        System.out.println("\nStarting test null");
        assertNotNull(analyseFlight);
        System.out.println("Finished test null");
    }

    @Test
    public void testAnalyse(){
        System.out.println("\nStarting test Analyse");

        when(planetPersistence.getPlanetByName("earth")).thenReturn(origin);
        when(planetPersistence.getPlanetByName("venus")).thenReturn(destination);
        analyseFlight.analyse();
        double test = 10;
        assertEquals(test,analyseFlight.getDistance());
        int durationTest = Days.daysBetween(flight.getDeparture().toLocalDate(), flight.getArrival().toLocalDate()).getDays();
        assertEquals(durationTest,analyseFlight.getDuration());
        verify(planetPersistence).getPlanetByName("earth");
        verify(planetPersistence).getPlanetByName("venus");
        System.out.println("End testing Analyse");
    }

}
