package com.group8.backspace.persistence.stubs;
import com.group8.backspace.objects.Item;
import com.group8.backspace.persistence.ItemPersistence;

public class ItemPersistenceStub implements ItemPersistence {
    @Override
    public Item getItem(String name)
    {
        if(name.equals("hyper sleep")) {
            return new Item(name,"travel class",10);
        }
        else if(name.equals("activities")) {
            return new Item(name,"travel class",99);
        }
        else if(name.equals("New York City")) {
            return new Item(name,"vr",49);
        }
        else if(name.equals("West World")) {
            return new Item(name,"vr",69);
        }
        else if(name.equals("Food paste")) {
            return new Item(name,"meal",99);
        }
        else if(name.equals("Irradiated meat")) {
            return new Item(name,"meal",20);
        }
        else if(name.equals("Dried drinks")) {
            return new Item(name,"meal",10);
        }
        else {
            throw new NullPointerException();
        }
    }
}
