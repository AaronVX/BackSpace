package com.group8.backspace;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.CalendarView;

import com.group8.backspace.presentation.MainActivity;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)

public class BrowseFlightsTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            System.out.println("Starting test: " + description.getMethodName());
        }
    };

    @Test
    public void bookFlight(){
        onView(withId(R.id.btn_book)).perform(click());
        onView(withId(R.id.btn_saturn)).perform(click());
        onView(withId(R.id.btn_jupiter)).perform(click());

//        onView(withId(R.id.calendar)).getChildAt(1).perform(click());
//        CalendarView view = (CalendarView) getActivity().findViewById(R.id.calendar);
//        onData(CoreMatchers.anything()).inAdapterView(withId(R.id.calendar)).getChildAt
    }
}
