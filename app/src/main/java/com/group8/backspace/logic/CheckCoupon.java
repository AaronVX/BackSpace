package com.group8.backspace.logic;

import com.group8.backspace.logic.exceptions.CouponException;

public class CheckCoupon {
    private String code;
    private int price;
    private final int LENGTH = 6;
    private final double RATIO = 0.9;

    public CheckCoupon(String code, int price){
        this.code = code;
        this.price = price;
    }

<<<<<<< HEAD
    public double checkCode(){
        if(code.length()==LENGTH) {
            return price * RATIO;
        }
        else{
            return 0;
        }
    }
=======
    public String getDiscount() throws CouponException {
        int discountPrice = (int)(price*RATIO);
        if (code.length() == LENGTH) {
            return "new price($): ".concat(Integer.toString(discountPrice));
        } else {
            return "Sorry, the code is invalid!";
        }
    }


>>>>>>> ce7a919f7e6ef87c777e74181f73b10df63b3acf
}

