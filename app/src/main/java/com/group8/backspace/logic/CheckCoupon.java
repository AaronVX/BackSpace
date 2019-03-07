package com.group8.backspace.logic;

public class CheckCoupon {
    private String code;
    private int price;

    public CheckCoupon(String code, int price){
        this.code = code;
        this.price = price;
    }

    public double checkCode(){
        if(code.length()==6){
            return price*0.9;
        }
        else
            return 0;
    }

}
