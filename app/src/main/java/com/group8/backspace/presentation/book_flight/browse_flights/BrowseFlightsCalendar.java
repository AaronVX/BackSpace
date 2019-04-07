package com.group8.backspace.presentation.book_flight.browse_flights;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.group8.backspace.R;
import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AnalyseDates;
import com.group8.backspace.logic.accessors.AccessFlights;
import com.group8.backspace.objects.Flight;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class BrowseFlightsCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_browse_calendar);

        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");

        // Update top images
        ImageView origin_view = (ImageView) findViewById(R.id.origin);
        origin_view.setImageResource(getResources().getIdentifier(
                "ic_" + origin , "drawable", getPackageName()));
        ImageView destination_view = (ImageView) findViewById(R.id.destination);
        destination_view.setImageResource(getResources().getIdentifier(
                "ic_" + destination , "drawable", getPackageName()));

        // Find flights
        AccessFlights accessFlights = new AccessFlights(Services.getFlightPersistence());
        final List<Flight> flights = accessFlights.getFutureFlights(origin, destination);

        MaterialCalendarView calendar = (MaterialCalendarView) findViewById(R.id.calendar);
        calendar.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);

        // Add available days to the calendar
        AnalyseDates analyseDates = new AnalyseDates(flights);
        ArrayList<DateTime> dates = analyseDates.extractUniqueDepartures();

        for (DateTime date : dates) {
            int year = date.getYear();
            int month = date.getMonthOfYear();
            int day = date.getDayOfMonth();
            calendar.setDateSelected(CalendarDay.from(year, month, day), true);
        }

        // transition
        Button btn_list_view = findViewById(R.id.btn_list_view);
        btn_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(BrowseFlightsCalendar.this, BrowseFlightsList.class);
                next.putExtra("origin", getIntent().getStringExtra("origin"));
                next.putExtra("destination", getIntent().getStringExtra("destination"));
                startActivity(next);
            }
        });


        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView,
                                       @NonNull CalendarDay calendarDay, boolean b) {
                // don't allow calendar selection changes
                materialCalendarView.setDateSelected(calendarDay, !b);

                // NOTE: assumes only one flight per day
                for (Flight flight : flights) {
                    if (flight.getDeparture().getYear() == calendarDay.getYear() &&
                        flight.getDeparture().getMonthOfYear() == calendarDay.getMonth() &&
                        flight.getDeparture().getDayOfMonth() == calendarDay.getDay()) {
                        materialCalendarView.setDateSelected(calendarDay, true); // re-select date

                        int chosenFlightNum = flight.getFlightID();

                        Intent detailIntent = new Intent(BrowseFlightsCalendar.this,
                                FlightDetailActivity.class);
                        detailIntent.putExtra("FLIGHT_NUM", chosenFlightNum);

                        startActivity(detailIntent); // TODO, 2 or more flights on the same day
                        return;
                    }
                }
            }
        });
    }
}
