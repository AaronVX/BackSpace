package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.objects.Location;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String test = getIntent().getStringExtra("planetName");

        AccessPlanets access = new AccessPlanets();

        Location loc = access.getPlanetByName(test);

        String test2 = loc.getId();

        TextView origin_view = (TextView) findViewById(R.id.planetinfo);
        origin_view.setText(test2);
    }

}
