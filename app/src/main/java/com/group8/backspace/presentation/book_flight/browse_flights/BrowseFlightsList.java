package com.group8.backspace.presentation.book_flight.browse_flights;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.group8.backspace.R;
import com.group8.backspace.application.Services;
import com.group8.backspace.logic.accessors.AccessFlights;
import com.group8.backspace.logic.accessors.AccessPlanets;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.util.list.ListAdapter;

import java.util.List;

public class BrowseFlightsList extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        AccessFlights accessFlights = new AccessFlights(Services.getFlightPersistence());
        AccessPlanets pAccess = new AccessPlanets(Services.getPlanetPersistence());

        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");

        final List<Flight> futureFlights = accessFlights.getFutureFlights(origin, destination);

        int flightNum[] = new int[futureFlights.size()];
        String flightStats[] = new String[futureFlights.size()];
        int flightIcon[] = new int[futureFlights.size()];

        Flight currFlight;
        String planetName;

        for(int i = 0; i < futureFlights.size(); i++){
            currFlight = futureFlights.get(i);
            flightNum[i] = currFlight.getFlightID();

            planetName = pAccess.getPlanetByName(currFlight.getDestination()).getId();
            flightIcon[i] = getResources().getIdentifier(
                    ("ic_".concat(planetName)),"drawable", getPackageName());

            //build flight stats string
            String stats = "Details:";

//        for (Flight flight : flights) {
//            DateTime departure = flight.getDeparture();
//            int year = departure.getYear();
//            int month = departure.getMonthOfYear();
//            int day = departure.getDayOfMonth();
//        }

//            DateHandler dateHandle = new DateHandler(
//                    currFlight.getDeparture(), currFlight.getArrival());
//            stats += dateHandle.getStrings()[1];

            flightStats[i] = stats;
        }

        ListView simpleList;
        simpleList = (ListView)findViewById(R.id.ListView);
        ListAdapter flightAdapter = new ListAdapter(
                BrowseFlightsList.this, FlightDetailActivity.class, flightNum, flightStats, flightIcon);
        simpleList.setAdapter(flightAdapter);

    }
}


