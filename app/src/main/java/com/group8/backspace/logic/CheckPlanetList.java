package com.group8.backspace.logic;

import com.group8.backspace.application.Services;
import com.group8.backspace.logic.accessors.AccessPlanets;
import com.group8.backspace.objects.Location;

import java.util.List;

public class CheckPlanetList {

    String destination;

    public CheckPlanetList(){
        destination = "";
    }

    public void setDestination(String origin) {
        this.destination = origin;
    }

    public String getDestination() {
        return destination;
    }

    public boolean hasOrigin() { //null value not possible by this method call
        boolean toReturn = false;
        AccessPlanets access = new AccessPlanets(Services.getPlanetPersistence());
        List<Location> planetList = access.getPlanets();

        for (int i = 0; i < planetList.size(); i++) {
            if (planetList.get(i).equals(destination)){
                toReturn = true;
            }
        }

        return toReturn;
    }
}