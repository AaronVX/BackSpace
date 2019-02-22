package com.group8.backspace.UI_test;

import com.group8.backspace.presentation.PlanetList_and_FlightStatus.FlightStatus;

import org.junit.Test;
import static org.junit.Assert.*;

public class BenTest {
    @Test
    public void testJUnit() {
        FlightStatus test = new FlightStatus();
        assertEquals("Flight #3045", (test.getItem())[0]);
    }

}