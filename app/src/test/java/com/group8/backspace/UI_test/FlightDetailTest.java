package com.group8.backspace.UI_test;

import com.group8.backspace.presentation.FlightDetailActivity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightDetailTest {

    //Evans tests
    @Test
    public void testJUnit() {
        FlightDetailActivity testDetail = new FlightDetailActivity();
        assertEquals("Flight #1520", (testDetail.getDetails())[0]);
    }
}
