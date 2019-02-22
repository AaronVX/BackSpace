package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.group8.backspace.R;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String test = getIntent().getStringExtra("planetName");

        TextView origin_view = (TextView) findViewById(R.id.planetinfo);
        origin_view.setText(test);
    }

}
