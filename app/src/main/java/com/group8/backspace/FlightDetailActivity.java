package com.group8.backspace;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;



public class FlightDetailActivity extends AppCompatActivity {

    // Arrays of stub data for the current flight
    String  names[] = {"Flight #1520", "Earth", "Mercury"}; //in order of flight name, departure, arrival
    String  times[] = {"Feb 3rd, 6:00AM", "4 Months, 7 Days, 11 hours", "June 10th, 5:00PM"}; //in order of depart time, total flight time, arrival time
    int planetPics[] = {R.drawable.ic_earth, R.drawable.ic_mercury}; //in order of depart pic, destination pic

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_detail);

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
        title.setText(names[0]);
        departPlanetName.setText(names[1]);
        destPlanetName.setText(names[2]);

        departTime.setText(times[0]);
        totalTime.setText(times[1]);
        arrivalTime.setText(times[2]);

        departPlanetPic.setImageResource(planetPics[0]);
        destPlanetPic.setImageResource(planetPics[1]);

        Button btn_travel = (Button) findViewById(R.id.btn_travel);
        btn_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FlightDetailActivity.this, TravelClass.class));
            }
        });
    }

    public String[] getDetails(){ return names; }
}
