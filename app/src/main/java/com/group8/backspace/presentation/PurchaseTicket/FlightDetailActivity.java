package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.Flight;


public class FlightDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_detail);

        //get the flight object selected via the flightNum passed by BookBrowseActivity
        AccessFlights accessor =  new AccessFlights();
        int currFlightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
        String originSrc = getIntent().getStringExtra("origin");
        String destinationSrc = getIntent().getStringExtra("destination");

        Flight currFlight = accessor.getFlightByID(currFlightNum);
        //Get the objects we want to set
        TextView title = (TextView) findViewById(R.id.detail_title);
        TextView departPlanetName = (TextView) findViewById(R.id.detail_depart_planet);
        TextView destPlanetName = (TextView) findViewById(R.id.detail_destination_planet);
        TextView departTime = (TextView) findViewById(R.id.detail_depart_text);
        TextView totalTime = (TextView) findViewById(R.id.detail_total_time);
        TextView arrivalTime = (TextView) findViewById(R.id.detail_destination_text);
        ImageView departPlanetPic = (ImageView) findViewById(R.id.detail_depart_pic);
        ImageView destPlanetPic = (ImageView) findViewById(R.id.detail_destination_pic);

        //set each text and picture slots to the given values
        String flightTitle = "Flight #"+currFlightNum;
        title.setText(flightTitle);
        departPlanetName.setText(currFlight.getOrigin());
        destPlanetName.setText(currFlight.getDestination());

        //use the date handler to get nice strings for textviews
        DateHandler handleDates = new DateHandler(currFlight.getDeparture(), currFlight.getArrival());
        String dates[] = handleDates.getStrings();

        departTime.setText(dates[0]);
        arrivalTime.setText(dates[1]);

        totalTime.setText(handleDates.getTravelTime());

        //use the "putExtra" tags for each picture
        departPlanetPic.setImageResource(getResources().getIdentifier("ic_" + originSrc , "mipmap", getPackageName()));
        destPlanetPic.setImageResource(getResources().getIdentifier("ic_" + destinationSrc , "mipmap", getPackageName()));

        Button btn_travel = (Button) findViewById(R.id.btn_travel);
        btn_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
                Intent detailIntent = new Intent(FlightDetailActivity.this, TravelClass.class);
                detailIntent.putExtra("FLIGHT_NUM", flightNum);
                startActivity(detailIntent);
            }
        });
    }
}
