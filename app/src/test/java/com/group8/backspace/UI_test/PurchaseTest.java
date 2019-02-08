package com.group8.backspace.UI_test;

import com.group8.backspace.presentation.PurchaseTicket;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class PurchaseTest {

    @Test
    public void testJUnit() {
        System.out.println("\nStarting testPurchaseTicket");
        PurchaseTicket test = new PurchaseTicket();
        assertTrue(test.checkFormat("1111111111111111","111111","111"));
        System.out.println("Finished testPurchaseTicket");
    }
}
