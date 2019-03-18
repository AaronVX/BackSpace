package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.objects.Location;
import com.group8.backspace.presentation.MainActivity;
import com.group8.backspace.presentation.PurchaseTicket.BookBrowseActivity;
import com.group8.backspace.presentation.PurchaseTicket.BookDestinationActivity;
import com.group8.backspace.presentation.PurchaseTicket.BookOriginActivity;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String nameFromList = getIntent().getStringExtra("planetName");

        AccessPlanets access = new AccessPlanets();

        Location loc = access.getPlanetByName(nameFromList);
        String planetName = loc.getId();
        final String displayName = planetName;
        planetName = planetName.substring(0,1).toUpperCase() + planetName.substring(1);
        String iconName = loc.getImgSrc();
        String desc = loc.getDescription();
        String pop = loc.getPopulation();
        String years = loc.getYears();
        years = planetName+" is "+years+" on Earth.";
        final String DEGREE  = "\u00b0"+"C";
        String low = loc.getMin()+DEGREE;
        String hi = loc.getMax()+DEGREE;

        int iconSrc = getResources().getIdentifier(iconName, "mipmap", getPackageName());

        TextView titleView = (TextView) findViewById(R.id.planetTitle);
        ImageView iconView = (ImageView) findViewById(R.id.planetIcon);
        TextView descView = (TextView) findViewById(R.id.description);
        TextView popView = (TextView) findViewById(R.id.pop);
        TextView minView = (TextView) findViewById(R.id.minTemp);
        TextView maxView = (TextView) findViewById(R.id.maxTemp);
        TextView yearView = (TextView) findViewById(R.id.years);

        titleView.setText(planetName);
        iconView.setImageResource(iconSrc);
        descView.setText(desc);
        popView.setText(pop);
        minView.setText(low);
        maxView.setText(hi);
        yearView.setText(years);

        Button btn_planetFromView = (Button) findViewById(R.id.planetFromLocations);
        btn_planetFromView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Info.this, BookDestinationActivity.class);
                intent.putExtra("origin", displayName);
                startActivity(intent);

            }
        });

        Button btn_planetToView = (Button) findViewById(R.id.planetToLocations);
        btn_planetToView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Info.this, BookOriginActivity.class);
                intent.putExtra("destination", displayName);
                startActivity(intent);

            }
        });
    }

}
