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

        Location newLocation1 = new Location("earth","ic_earth","365.25 days","-88","58","7.53 billion","1","Earth is the third planet from the Sun and is the largest of the terrestrial planets. Three quarters of its surface is covered by water! The Earth is the only planet in our solar system not to be named after a Greek or Roman deity. It was formed approximately 4.54 billion years ago and is the only known planet to support life...so far!", "a warm wet blue and green planet");
        Location newLocation2 = new Location("venus","ic_venus","255 days","462","471","0","0.723","Venus is the second planet from the Sun and is the second brightest object in the night sky. This is due to its deadly, yellow clouds of sulphuric acid that reflect the suns light. These clouds also trap heat in a greenhouse effect, making it the hottest planet in our solar system! Named after the Roman goddess of love and beauty, Venus is the second largest terrestrial planet and is sometimes referred to as the Earths sister planet!", "a hot hell-hole filled with volcanoes and sulphuric acid");
        locations.add(newLocation1);
        locations.add(newLocation2);
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
