package com.group8.backspace.presentation.book_flight.browse_flights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.group8.backspace.R;
import com.group8.backspace.application.Services;
import com.group8.backspace.logic.accessors.AccessFlights;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.util.DateHandler;
import com.group8.backspace.presentation.util.list_adapters.FlightListAdapter;

import java.util.List;

public class BrowseFlightsList extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_browse_list);

        AccessFlights accessFlights = new AccessFlights(Services.getFlightPersistence());

        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");

        ImageView origin_view = (ImageView) findViewById(R.id.origin);
        origin_view.setImageResource(getResources().getIdentifier(
                "ic_".concat(origin) , "drawable", getPackageName()));
        ImageView destination_view = (ImageView) findViewById(R.id.destination);
        destination_view.setImageResource(getResources().getIdentifier(
                "ic_".concat(destination) , "drawable", getPackageName()));

        final List<Flight> futureFlights = accessFlights.getFutureFlights(origin, destination);

        int flightNum[] = new int[futureFlights.size()];
        String flightStats[] = new String[futureFlights.size()];
        int flightIcon[] = new int[futureFlights.size()];

        Flight currFlight;

        for(int i = 0; i < futureFlights.size(); i++){
            currFlight = futureFlights.get(i);
            int flightId = currFlight.getFlightID();

            flightNum[i] = flightId;

            int iconNum = flightNum[i]%7;
            String source = "ic_flight".concat(String.valueOf(iconNum));

            flightIcon[i] = getResources().getIdentifier(source,"drawable", getPackageName());

            //use the date handler to get nice strings for textviews
            DateHandler handleDates = new DateHandler(currFlight.getDeparture(), currFlight.getArrival());
            String dates[] = handleDates.getStrings();
            StringBuilder stats = new StringBuilder();
            stats.append( "Departure: ".concat(dates[0]) );
            stats.append( "\nArrival: ".concat(dates[1]) );
            flightStats[i] = stats.toString();
        }

        ListView simpleList;
        simpleList = (ListView)findViewById(R.id.ListView);
        FlightListAdapter flightAdapter = new FlightListAdapter(
                BrowseFlightsList.this, FlightDetailActivity.class, flightNum, flightStats, flightIcon);
        simpleList.setAdapter(flightAdapter);

        // transitions
        Button btn_list_view = findViewById(R.id.btn_calendar_view);
        btn_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(BrowseFlightsList.this, BrowseFlightsCalendar.class);
                next.putExtra("origin", getIntent().getStringExtra("origin"));
                next.putExtra("destination", getIntent().getStringExtra("destination"));
                startActivity(next);
            }
        });

    }
}


