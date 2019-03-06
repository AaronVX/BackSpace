package com.group8.backspace.objects;

public class Price {

    private String item, type;
    private int price;
    public Price(String item, String type, int price)
    {
        this.item = item;
        this.type = type;
        this.price = price;
    }

    public String getItem() { return item; }
    public String getType() { return type; }
    public int getPrice() { return price; }
}
