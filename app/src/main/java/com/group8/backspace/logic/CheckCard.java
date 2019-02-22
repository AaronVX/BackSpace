package com.group8.backspace.logic;

public class CheckCard {
    private String cardNum;
    private String date;
    private String securityNum;

    public CheckCard(String cardNum, String date, String securityNum){
        this.cardNum = cardNum;
        this.date = date;
        this.securityNum = securityNum;
    }

    public boolean checkFormat(String cardNum, String date, String securityNum){
        if(cardNum.length()==16&&date.length()==6&&securityNum.length()==3){
            return true;
        }
        else
            return false;
    }

}
