package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.group8.backspace.R;

public class PlanetList extends AppCompatActivity {
    ListView simpleList;
    String Planet[] = {"earth", "venus", "mars"}; //temp info to replace with sql db
    String Description[] = {"A warm blue and green planet", "A hot hell hole filled with volcanoes and sulphuric acid", "A calm cold red planet covered in dust"};
    int Icons[] = {R.mipmap.ic_earth, R.mipmap.ic_venus, R.mipmap.ic_mars};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_list);

        simpleList = (ListView)findViewById(R.id.ListView); //makes listview based on info fed in
        CustomAdapter customAdapter = new CustomAdapter(PlanetList.this, Planet, Description, Icons);
        simpleList.setAdapter(customAdapter);
    }
}
