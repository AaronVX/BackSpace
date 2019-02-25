package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.objects.Location;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String nameFromList = getIntent().getStringExtra("planetName");

        AccessPlanets access = new AccessPlanets();

        Location loc = access.getPlanetByName(nameFromList);
        String planetName = loc.getId();
        String iconName = loc.getImgSrc();

        int iconSrc = getResources().getIdentifier(iconName, "mipmap", getPackageName());

        TextView titleView = (TextView) findViewById(R.id.planetTitle);
        ImageView iconView = (ImageView) findViewById(R.id.planetIcon);
        titleView.setText(planetName);
        iconView.setImageResource(iconSrc);
    }

}
