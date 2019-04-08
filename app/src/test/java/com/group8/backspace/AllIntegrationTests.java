package com.group8.backspace;

import com.group8.backspace.IntegrationTests.AccessFlightsIT;
import com.group8.backspace.IntegrationTests.AccessItemsIT;
import com.group8.backspace.IntegrationTests.AccessPlanetIT;
import com.group8.backspace.IntegrationTests.CheckPlanetListIT;
import com.group8.backspace.logic.CheckPlanetList;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessFlightsIT.class,
        AccessItemsIT.class,
        AccessPlanetIT.class,
        CheckPlanetListIT.class
})
public class AllIntegrationTests {

}
