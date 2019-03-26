package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.DateHandler;

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

    AccessFlights access = new AccessFlights();
    AccessPlanets pAccess = new AccessPlanets();
    List<Flight> ongoingFlights = access.getCurrentFlights();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_status);

        int flightNum[] = new int[ongoingFlights.size()];
        String flightStats[] = new String[ongoingFlights.size()];
        int flightIcon[] = new int[ongoingFlights.size()];
        Flight currFlight;
        for(int i = 0; i < ongoingFlights.size(); i++){
            currFlight = ongoingFlights.get(i);
            flightNum[i] = currFlight.getFlightID();
            flightIcon[i] = getResources().getIdentifier(pAccess.getPlanetByName(currFlight.getDestination()).getImgSrc(), "mipmap", getPackageName());

            //build flight stats string
            String stats = "Status: ";
            if(currFlight.isDead()){
                stats = stats + "Crew Dead\nFlight Stage: Failure\nETA: Unknown";
            } else {
                if(currFlight.isDelayed()){
                    stats += "Delayed\nFlight Stage: ";
                } else {
                    stats += "On Time\nFlight Stage: ";
                }

                if(currFlight.getStatus() == 1) {
                    stats += "Leaving Orbit\nETA: ";
                } else if( currFlight.getStatus() == 2) {
                    stats += "In Transfer\nETA: ";
                } else if( currFlight.getStatus() == 3){
                    stats += "Deorbiting\nETA: ";
                }

                DateHandler dateHandle = new DateHandler(currFlight.getDeparture(), currFlight.getArrival());
                stats += dateHandle.getStrings()[1];
            }
            flightStats[i] = stats;
        }
        simpleList = (ListView)findViewById(R.id.ListView);
        FlightListAdapter flightAdapter = new FlightListAdapter(FlightStatus.this, flightNum, flightStats, flightIcon);
        simpleList.setAdapter(flightAdapter);
    }

    public String[] getItem()
    {
        return flightName;
    }
}
