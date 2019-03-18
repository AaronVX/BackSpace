package com.group8.backspace.logic;

public class CheckCoupon {
    private String code;
    private int price;
    private double discountRate = 0.90;

    public CheckCoupon(String code, int price){
        this.code = code;
        this.price = price;
    }

    public double checkCode(){
        if(code.length()==6){
            return price*discountRate;
        }
        else
            return 0;
    }

}
