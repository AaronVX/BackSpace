package com.group8.backspace.logic;

public class CheckCard {
    private final int CARD_LENGTH = 16;
    private final int DATE_LENGTH = 4;
    private final int SECURITY_LENGTH = 3;


    public boolean checkFormat(String cardNum, String date, String securityNum){
        if(cardNum.length()==CARD_LENGTH&&date.length()==DATE_LENGTH&&securityNum.length()==SECURITY_LENGTH){
            return true;
        }
        else
            return false;
    }

}
