package com.group8.backspace.logic;

public class CheckCoupon {
    private String code;
    private int price;
    private final int LENGTH = 6;
    private final double RATIO = 0.9;

    public CheckCoupon(String code, int price){
        this.code = code;
        this.price = price;
    }

    public boolean checkCode() throws CouponException{
        if (code.length() == LENGTH) {
            return true;
        } else {
            return false;
        }
    }

    public int getDiscount(){
        return (int)(price*RATIO);
    }
}

