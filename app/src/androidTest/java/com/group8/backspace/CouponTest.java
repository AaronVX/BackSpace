package com.group8.backspace;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Rational;

import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.AccessItems;
import com.group8.backspace.logic.AnalyseFlight;
import com.group8.backspace.logic.CalculatePrices;
import com.group8.backspace.logic.CheckCoupon;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.MainActivity;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
public class CouponTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            System.out.println("Starting test: " + description.getMethodName());
        }
    };

    @Before
    public void setup() {
        onView(withId(R.id.btn_book)).perform(click());
        onView(withId(R.id.btn_saturn)).perform(click());
        onView(withId(R.id.btn_jupiter)).perform(click());

        onView(withId(R.id.calendar)).perform(click());
        onView(withId(R.id.btn_travel)).perform(click());
        onView(withId(R.id.imageEconomy)).perform(click());
        onView(withId(R.id.btn_purchase)).perform(click());
    }

    @Test
    public void couponTest() {
        closeSoftKeyboard();
        onView(withId(R.id.code)).perform(typeText("12346"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_code)).perform(click());
        onView(withId(R.id.newPrice)).check(matches(withText("Sorry, the code is invalid!")));
        onView(withId(R.id.code)).perform(typeText("1"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_code)).perform(click());
        //calculate discount price
        AccessFlights flights = new AccessFlights(Services.getFlightPersistence());
        List<Flight> list  = flights.getFutureFlights("saturn","jupiter");
        Flight flight = getFlight(list,new DateTime("2019-04-09"));
        AnalyseFlight analyseFlight = new AnalyseFlight(flight, Services.getPlanetPersistence());
        analyseFlight.analyse();
        AccessItems items = new AccessItems(Services.getItemPersistence());
        int price = items.getItemByName("hyper sleep").getPrice();
        final int ITEM_PRICE = 0;
        CalculatePrices prices = new CalculatePrices(analyseFlight.getDistance(),
                analyseFlight.getDuration(),price,ITEM_PRICE);
        int totalPrice = prices.calculateTotalPrice();
        CheckCoupon check = new CheckCoupon("123461",totalPrice);

        onView(withId(R.id.newPrice)).check(matches(withText("new price($): ".concat(Integer.toString(check.getDiscount())))));

    }


    public Flight getFlight(List<Flight> list, DateTime curr) {
        for (Flight flight : list) {
            if (flight.getDeparture().isAfter(curr)) {
                return flight;
            }
        }
        throw new RuntimeException("Error, flight should be in the list");
    }
}
