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
    public void test1()
    {
        final Location location;
        System.out.println("\nStarting test AccessPlanets");

        location = accessPlanets.getPlanetByName("earth");
        assertNotNull("first planet should not be null", location);

        assertTrue("ic_earth".equals(location.getImgSrc()));
        assertTrue("365.25 days".equals(location.getYears()));
        assertTrue("-88".equals(location.getMin()));
        assertTrue("58".equals(location.getMax()));
        assertTrue("7.53 billion".equals(location.getPopulation()));
        assertTrue("1".equals(location.getDistance()));

        System.out.println("Finished test AccessPlanets");
    }
}
