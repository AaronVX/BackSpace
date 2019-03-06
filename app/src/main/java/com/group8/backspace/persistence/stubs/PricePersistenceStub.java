package com.group8.backspace.persistence.stubs;
import com.group8.backspace.objects.Price;
import com.group8.backspace.persistence.PricePersistence;

public class PricePersistenceStub implements PricePersistence {
    @Override
    public Price getPrice(String name)
    {
        if(name.equals("hyper sleep"))
        {
            return new Price(name,"travel class",10);
        }
        else if(name.equals("activities"))
        {
            return new Price(name,"travel class",99);
        }
        else
        {
            throw new NullPointerException();
        }
    }
}
