package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.group8.backspace.R;

/*
    https://www.andrious.com/tutorials/listview-tutorial-with-example-in-android-studio/
    this tutorial helped shape the FlightStatus.java, Listview.java CustomAdapter,java activity_listview.xml,
    and activity_flight_status.xml

    The code copied was the the new customer adapter that overwrites viewlist to show a picture, title, and information

    4 hours was spent on this view
 */

public class FlightStatus extends AppCompatActivity {
    // Array of stub data for the flight
        ListView simpleList;
        String  Item[] = {"Flight #3045", "Flight #4509", "Flight #4398", "Flight #0986", "Flight #7654"};
        String  SubItem[] = {"Status: On Time\nFlight Stage: In Orbit\nETA: April 3rd, 2025",
                "Status: Delayed\nFlight Stage: Deorbiting\nETA: February 17th 2019",
                "Status: On Time\nFlight Stage: In Transfer\nETA: May 1st 2076",
                "Status: Early\nFlight Stage: In Transfer\nETA: January 7th 2023",
                "Status: Crew Dead\nFlight Stage: Unknown\nETA: N/A"};
        int flags[] = {R.mipmap.ic_earth, R.mipmap.ic_mercury, R.mipmap.ic_venus, R.mipmap.ic_earth, R.mipmap.ic_venus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_status);

        simpleList = (ListView)findViewById(R.id.ListView);
        CustomAdapter customAdapter = new CustomAdapter(FlightStatus.this, Item, SubItem, flags);
        simpleList.setAdapter(customAdapter);
    }

    public String[] getItem()
    {
        return Item;
    }
}
