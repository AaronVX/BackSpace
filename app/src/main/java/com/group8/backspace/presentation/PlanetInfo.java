package com.group8.backspace.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.group8.backspace.R;

public class PlanetInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_info);

        String test = getIntent().getStringExtra("planetName");

        TextView origin_view = (TextView) findViewById(R.id.planetinfo);
        origin_view.setText(test);
    }

}
