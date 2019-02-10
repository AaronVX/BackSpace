package com.group8.backspace;

import com.group8.backspace.UI_test.BenTest;
import com.group8.backspace.UI_test.DateHandlerTest;
import com.group8.backspace.UI_test.PurchaseTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        PurchaseTest.class,
        BenTest.class,
        DateHandlerTest.class,
})
public class AllTest
{

}