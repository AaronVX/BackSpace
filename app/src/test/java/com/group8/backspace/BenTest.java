package com.group8.backspace;

import org.junit.Test;
import static org.junit.Assert.*;

public class BenTest {
    @Test
    public void testJUnit() {
        FlightStatus test = new FlightStatus();
        assertEquals("Flight #3045", (test.getItem())[0]);
    }

    //Evans tests
    @Test
    public void testJUnit() {
        FlightDetailActivity testDetail = new FlightDetailActivity();
        assertEquals("Flight #1520", (testDetail.getDetails())[0]);
    }
}