package com.group8.backspace.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.CurrentFlights;

import java.util.List;

public class PlanetList extends AppCompatActivity {

    ListView simpleList;
    String Planet[] = {"Earth", "Venus", "Mars"};
    String Description[] = {"A warm blue and green planet", "a hot hellhole filled with volcanoes and sulphuric acid", "A calm cold red planet covered in dust"};
    int Icons[] = {R.mipmap.ic_earth, R.mipmap.ic_venus, R.mipmap.ic_mars};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_list);

        simpleList = (ListView)findViewById(R.id.ListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), Planet, Description, Icons);
        simpleList.setAdapter(customAdapter);
    }
}
