package com.group8.backspace.presentation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.List;

public class BookBrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_browse);

        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");


        // Update top images
        ImageView origin_view = (ImageView) findViewById(R.id.origin);
        origin_view.setImageResource(getResources().getIdentifier("ic_" + origin , "drawable", getPackageName()));
        ImageView destination_view = (ImageView) findViewById(R.id.destination);
        destination_view.setImageResource(getResources().getIdentifier("ic_" + destination , "drawable", getPackageName()));

        AccessFlights accessFlights = new AccessFlights();
        final List<Flight> flights = accessFlights.getFutureFlights(Location.getByName(origin), Location.getByName(destination));

        MaterialCalendarView calendar = (MaterialCalendarView) findViewById(R.id.calendar);
        calendar.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);


        for (Flight flight : flights) {
            calendar.setDateSelected(flight.getDeparture(), true);
        }



        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView, @NonNull CalendarDay calendarDay, boolean b) {
                // don't allow selection of non-selected dates
                if (b) {
                    materialCalendarView.setDateSelected(calendarDay, false);
                }

                // NOTE: assumes only one flight per day
                for (Flight flight : flights) {
                    if (flight.getDeparture().equals(calendarDay)) {
                        // TODO switch to details activity, with flight object as extra

                        //testing
                        Toast.makeText(getBaseContext(),flight.getDestination().name(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
