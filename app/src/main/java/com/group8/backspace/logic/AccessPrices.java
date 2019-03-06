package com.group8.backspace.logic;
import com.group8.backspace.persistence.PricePersistence;
import com.group8.backspace.application.Services;
import com.group8.backspace.objects.Price;

public class AccessPrices {

    private PricePersistence pricePersistence;

    public AccessPrices() {
        pricePersistence = Services.getPricePersistence();
    }

    public Price getPriceByItem(String itemName) {
        return pricePersistence.getPrice(itemName);
    }

}
