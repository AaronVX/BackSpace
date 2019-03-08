package com.group8.backspace.logic;

public class CheckCard {

    public boolean checkFormat(String cardNum, String date, String securityNum){
        if(cardNum.length()==16&&date.length()==4&&securityNum.length()==3){
            return true;
        }
        else
            return false;
    }

}
