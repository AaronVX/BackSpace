package com.group8.backspace.logic;

public class CheckDiscountCode {
    private String code;
    private int price;

    public CheckDiscountCode(String code, int price){
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
