package com.group8.backspace.persistence.stubs;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.PlanetPersistence;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PlanetPersistenceStub implements PlanetPersistence {
    List<Location> locations;

    public PlanetPersistenceStub(){
        locations = new ArrayList<Location>();

        Location newLocation = new Location("1","2","3","4","5","6","7","8", "9");
        locations.add(newLocation);
    }

    @Override
    public List<Location> getPlanets() {
        return Collections.unmodifiableList(locations);
    }

    @Override
    public Location getPlanetByName(String locationName) {
        Location plantFound = null;
        for(Location location : locations) {
            if(location.getId().equals(locationName)) {
                plantFound = location;
            }
        }
        return plantFound;
    }
}
