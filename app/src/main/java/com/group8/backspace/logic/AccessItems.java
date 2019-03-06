package com.group8.backspace.logic;
import com.group8.backspace.persistence.ItemPersistence;
import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Item;

public class AccessItems {

    private ItemPersistence itemPersistence;

    public AccessItems() {
        itemPersistence = Services.getItemPersistence();
    }

    public Item getItemByName(String itemName) {
        return itemPersistence.getItem(itemName);
    }

}
