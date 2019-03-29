package com.group8.backspace.presentation.PlanetList_and_FlightStatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.group8.backspace.R;
import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.objects.Location;

import java.util.List;

public class PlanetList extends AppCompatActivity {
    ListView simpleList;

    AccessPlanets access = new AccessPlanets(Services.getPlanetPersistence());
    List<Location> planetList = access.getPlanets();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_list);

        String planetName[] = new String[planetList.size()];
        String planetDescription[] = new String[planetList.size()];
        int planetIcon[] = new int[planetList.size()];
        for(int i = 0; i < planetList.size(); i++){
            planetName[i] = (planetList.get(i)).getId();
            planetDescription[i] = (planetList.get(i)).getShortDesc();
            planetIcon[i] = getResources().getIdentifier((planetList.get(i).getImgSrc()), "drawable", getPackageName());
        }

        simpleList = (ListView)findViewById(R.id.ListView); //makes listview based on info fed in
        CustomAdapter customAdapter = new CustomAdapter(PlanetList.this, planetName, planetDescription, planetIcon);
        simpleList.setAdapter(customAdapter);
    }
}
