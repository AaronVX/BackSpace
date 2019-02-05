package com.group8.backspace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PurchaseTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);

        TextView ticketPrice = (TextView) findViewById(R.id.ticketPrice);
        TextView classPrice = (TextView) findViewById(R.id.classPrice);
        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);
        int ticketP = 12;
        int classP = 14;
        int total = ticketP + classP;
        ticketPrice.setText(ticketP + "");
        classPrice.setText(classP + "");
        totalPrice.setText(total + "");

        EditText cardNum = (EditText) findViewById(R.id.cardNum);
        EditText expiryDate = (EditText) findViewById(R.id.expiry_date);
        EditText securityCode = (EditText) findViewById(R.id.security_code);

        final String card = cardNum.getText().toString();
        final String date = expiryDate.getText().toString();
        final String code = securityCode.getText().toString();

        Button purchaseBtn = (Button) findViewById(R.id.btn_purchase);
        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView condition = (TextView) findViewById(R.id.condition);
                if(checkFormat(card,date,code)){
                    condition.setText("purchase succeed");
                }
                else{
                    condition.setText("purchase failed");
                }

            }
        });
    }
    public boolean checkFormat(String cardNum, String date, String securityNum){
        if(cardNum.length()==16&&date.length()==6&&securityNum.length()==3){
            return true;
        }
        else
            return false;
    }
}
