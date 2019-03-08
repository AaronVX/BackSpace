package com.group8.backspace.logic;

import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Location;
import com.group8.backspace.persistence.PlanetPersistence;

import java.util.Collections;
import java.util.List;

public class AccessPlanets {

    private PlanetPersistence planetPersistence;

    public AccessPlanets() {
        planetPersistence = Services.getPlanetPersistence();
    }

    public AccessPlanets(final PlanetPersistence planetPersistence) {
        this();
        this.planetPersistence = planetPersistence;
    }

    public List<Location> getPlanets() {
        return Collections.unmodifiableList(planetPersistence.getPlanets());
    }

    public Location getPlanetByName(String planetName) {
        return planetPersistence.getPlanetByName(planetName);
    }

}
