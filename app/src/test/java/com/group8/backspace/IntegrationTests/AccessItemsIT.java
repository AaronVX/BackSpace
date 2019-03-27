package com.group8.backspace.IntegrationTests;

import com.group8.backspace.logic.AccessItems;
import com.group8.backspace.objects.Item;
import com.group8.backspace.persistence.ItemPersistence;
import com.group8.backspace.persistence.hsqldb.ItemPersistenceHSQLDB;
import com.group8.backspace.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessItemsIT {
    private AccessItems accessItems;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final ItemPersistence persistence = new ItemPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessItems = new AccessItems(persistence);
    }

    @Test
    public void testGetItemByName(){
        final Item item;
        

    }
}
