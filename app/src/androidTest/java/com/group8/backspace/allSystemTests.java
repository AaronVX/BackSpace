package com.group8.backspace;

import com.group8.backspace.presentation.PurchaseTicket.BookReview;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdditionalExpenseTest.class,
        BookReviewTest.class,
        BrowseFlightsTest.class,
        CouponTest.class,
        FlightStatusTest.class,
        PlanetViewTest.class,
        PurchaseTest.class,
        TrackFlightsTest.class,
        TravelClassSelectionTest.class,
})
public class allSystemTests {
}
