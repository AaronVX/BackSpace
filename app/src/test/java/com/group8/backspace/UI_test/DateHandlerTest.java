package com.group8.backspace.UI_test;

import com.group8.backspace.presentation.PurchaseTicket.DateHandler;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateHandlerTest {

        @Test
        public void testJUnit() {
            CalendarDay from = CalendarDay.from(2019,2,14);
            CalendarDay to = CalendarDay.from(2019,5,20);

            DateHandler testHandler = new DateHandler(from, to);
            assertEquals("95 days", (testHandler.getTravelTime()));

            assertEquals("2019-02-14", (testHandler.getStrings())[0]);
        }
}
