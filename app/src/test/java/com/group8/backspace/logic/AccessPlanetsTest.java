package com.group8.backspace.logic;

import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.stubs.PlanetPersistenceStub;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessPlanetsTest {
    private AccessPlanets accessPlanets;
    @Before
    public void setUp() {
        accessPlanets = new AccessPlanets(new PlanetPersistenceStub());
    }

    @Test
    public void test1(){
        final Location location;
        System.out.println("\nStarting test AccessPlanets");

        location = accessPlanets.getPlanetByName("1");
        assertNotNull("first planet should not be null", location);

        assertTrue("2".equals(location.getImgSrc()));
        assertTrue("3".equals(location.getYears()));
        assertTrue("4".equals(location.getMin()));
        assertTrue("5".equals(location.getMax()));
        assertTrue("6".equals(location.getPopulation()));
        assertTrue("7".equals(location.getDistance()));
        assertTrue("8".equals(location.getDescription()));

        System.out.println("Finished test AccessPlanets");
    }
}
