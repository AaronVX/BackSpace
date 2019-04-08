package com.group8.backspace.IntegrationTests;

import com.group8.backspace.application.Services;
import com.group8.backspace.logic.CheckPlanetList;
import com.group8.backspace.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.IOException;

public class CheckPlanetListIT {
    private CheckPlanetList checkPlanetList;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        this.checkPlanetList = Services.getPlanetList();
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
        checkPlanetList = null;
        System.out.println("clear " + tempDB.delete());
        Services.resetAccess();
    }
    @Test
    public void testHasOrigin(){
        checkPlanetList.setDestination("earth");
        assertTrue(checkPlanetList.hasOrigin());
        checkPlanetList.setDestination("");
        assertFalse(checkPlanetList.hasOrigin());
        System.out.println("End testing HasOrigin");
    }
}
