package com.group8.backspace.persistence;
import  com.group8.backspace.objects.Price;

public interface PricePersistence {
    Price getPrice(String name);
}
