package com.group8.backspace.logic;

import com.group8.backspace.objects.Flight;
import com.group8.backspace.objects.Item;
import com.group8.backspace.persistence.stubs.FlightPersistenceStub;
import com.group8.backspace.persistence.stubs.ItemPersistenceStub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessItemsTest {
    private AccessItems accessItems;

    @Before
    public void setUp() {accessItems = new AccessItems(new ItemPersistenceStub()); }

    @Test
    public void test1()
    {
        final Item item;
        System.out.println("\nStarting test AccessItems");

        item = accessItems.getItemByName("hyper sleep");
        assertNotNull("first item should not be null", item);
        assertTrue("travel class".equals(item.getType()));

        System.out.println("Finished test AccessItems");
    }
}
