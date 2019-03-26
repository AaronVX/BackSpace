package com.group8.backspace.objects;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LocationTest {
    @Test
    public void testLocation1() {
        Location location;

        System.out.println("\nStarting testLocation");

        location = new Location("mercury");
        assertNotNull(location);

        assertTrue("mercury".equals(location.getId()));
        assertTrue("ic_mercury".equals(location.getImgSrc()));
        assertTrue("88 days".equals(location.getYears()));
        assertTrue("-173".equals(location.getMin()));
        assertTrue("427".equals(location.getMax()));
        assertTrue("0".equals(location.getPopulation()));
        assertTrue("0.39".equals(location.getDistance()));
        assertTrue("Mercury".equals(location.getDescription()));

        System.out.println("Finished testLocation");
    }
}
