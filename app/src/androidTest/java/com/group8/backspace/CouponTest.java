package com.group8.backspace;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

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

        final String DISCOUNT_PRICE = "11742";
        onView(withId(R.id.newPrice)).check(matches(withText("new price($): ".concat(DISCOUNT_PRICE))));

    }


}
