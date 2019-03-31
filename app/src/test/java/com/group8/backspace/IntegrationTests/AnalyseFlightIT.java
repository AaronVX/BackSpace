package com.group8.backspace.IntegrationTests;

import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AnalyseFlight;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.persistence.FlightPersistence;
import com.group8.backspace.persistence.PlanetPersistence;
import com.group8.backspace.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.group8.backspace.persistence.hsqldb.PlanetPersistenceHSQLDB;
import com.group8.backspace.utils.TestUtils;

import com.group8.backspace.objects.Location;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnalyseFlightIT {
    private AnalyseFlight analyseFlight;
    private Flight flight;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final PlanetPersistence persistence = new PlanetPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        flight = new Flight(1, "earth", "venus", new DateTime(1546797600), DateTime.now());
        this.analyseFlight = new AnalyseFlight(flight,persistence);
    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            System.out.println("Starting test: " + description.getMethodName());
        }
    };

    @After
    public void tearDown() {
        System.out.println("Done!");
        analyseFlight = null;
        System.out.println("clear " + tempDB.delete());
    }

    @Test
    public void testAnalyse(){
        analyseFlight.analyse();
        int durationTest = analyseFlight.getDuration();
        double distanceTest = analyseFlight.getDistance();

        assertEquals(17969,durationTest);
        assertEquals(0.277,distanceTest,0.01);
        System.out.println("End testing Analyse");
    }
}
