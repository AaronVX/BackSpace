package com.group8.backspace;

import com.group8.backspace.UI_test.BenTest;
import com.group8.backspace.UI_test.PurchaseTest;
import com.group8.backspace.UI_test.FlightDetailTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        PurchaseTest.class,
        BenTest.class,
        FlightDetailTest.class,
})
public class AllTest
{

}