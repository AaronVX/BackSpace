package com.group8.backspace;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.MainActivity;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
@RunWith(AndroidJUnit4.class)
public class FlightStatusTest {
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
    }

    @Test
    public void testFlightStatus(){
        onView(withId(R.id.detail_depart_planet)).check(matches(withText("Saturn")));
        onView(withId(R.id.detail_destination_planet)).check(matches(withText("Jupiter")));
        AccessFlights flights = new AccessFlights(Services.getFlightPersistence());
        List<Flight> list  = flights.getFutureFlights("saturn","jupiter");
        System.out.println(list.get(0).getFlightID());

    }
}
