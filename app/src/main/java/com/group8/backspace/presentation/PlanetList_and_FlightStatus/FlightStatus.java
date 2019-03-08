package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.objects.Flight;

import java.util.List;

/*
    https://www.andrious.com/tutorials/listview-tutorial-with-example-in-android-studio/
    this tutorial helped shape the FlightStatus.java, Listview.java CustomAdapter,java activity_listview.xml,
    and activity_flight_status.xml

    The code copied was the the new customer adapter that overwrites viewlist to show a picture, title, and information

    4 hours was spent on this view
 */

public class FlightStatus extends AppCompatActivity {
    ListView simpleList;
    String flightName[];
    String flightStats[];

    AccessFlights access = new AccessFlights();
    AccessPlanets pAccess = new AccessPlanets();
    List<Flight> ongoingFlights = access.getCurrentFlights();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_status);

        String flightName[] = new String[ongoingFlights.size()];
        String flightStats[] = new String[ongoingFlights.size()];
        int flightIcon[] = new int[ongoingFlights.size()];
        for(int i = 0; i < ongoingFlights.size(); i++){
            flightName[i] = "Flight #"+ongoingFlights.get(i).getFlightID();
            flightStats[i] = ongoingFlights.get(i).getStatus();
            flightIcon[i] = getResources().getIdentifier(pAccess.getPlanetByName(ongoingFlights.get(i).getDestination()).getImgSrc(), "mipmap", getPackageName());
        }
        simpleList = (ListView)findViewById(R.id.ListView);
        FlightListAdapter flightAdapter = new FlightListAdapter(FlightStatus.this, flightName, flightStats, flightIcon);
        simpleList.setAdapter(flightAdapter);
    }

    public String[] getItem()
    {
        return flightName;
    }
}
