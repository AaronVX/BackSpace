package com.group8.backspace.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;
import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.CurrentFlights;

/*
    https://www.andrious.com/tutorials/listview-tutorial-with-example-in-android-studio/
    this tutorial helped shape the FlightStatus.java, Listview.java CustomAdapter,java activity_listview.xml,
    and activity_flight_status.xml

    The code copied was the the new customer adapter that overwrites viewlist to show a picture, title, and information

    4 hours was spent on this view
 */

public class FlightStatus extends AppCompatActivity {

    private boolean sqldb = false;

    // Array of stub data for the flight
        ListView simpleList;
        String  Item[] = {"Flight #3045", "Flight #4509", "Flight #4398", "Flight #0986", "Flight #7654"};
        String  SubItem[] = {"Status: On Time\nFlight Stage: In Orbit\nETA: April 3rd, 2025",
                "Status: Delayed\nFlight Stage: Deorbiting\nETA: February 17th 2019",
                "Status: On Time\nFlight Stage: In Transfer\nETA: May 1st 2076",
                "Status: Early\nFlight Stage: In Transfer\nETA: January 7th 2023",
                "Status: Crew Dead\nFlight Stage: Unknown\nETA: N/A"};
        int flags[] = {R.drawable.ic_earth, R.drawable.ic_mercury, R.drawable.ic_venus, R.drawable.ic_earth, R.drawable.ic_venus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_status);

        if (sqldb) {
            AccessFlights getCurrentFlights = new AccessFlights();
            List<CurrentFlights> list = getCurrentFlights.getAllInfo();
            CurrentFlights test = list.get(0);
            String test2 = test.toString();
            String test3[] = {test2};
            simpleList = (ListView)findViewById(R.id.ListView);
            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), Item, test3, flags);
            simpleList.setAdapter(customAdapter);
        }
        else
        {
            simpleList = (ListView)findViewById(R.id.ListView);
            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), Item, SubItem, flags);
            simpleList.setAdapter(customAdapter);
        }
    }

    public String[] getItem()
    {
        return Item;
    }
}
