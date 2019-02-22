package com.group8.backspace.presentation.PurchaseTicket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.objects.Flight;

public class PurchaseTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);


        //get the flight object selected via the flightNum passed by BookBrowseActivity
        AccessFlights accessor =   new AccessFlights();
        int currFlightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
        int currClassPrice = getIntent().getIntExtra("Class_Price", 0);
        Flight currFlight = accessor.getFlightByNum(currFlightNum);



        TextView flightNum = (TextView) findViewById(R.id.flight_view);
        String flightTitle = "Flight #"+currFlightNum;
        flightNum.setText(flightTitle);

        //calculate total price
        TextView ticketPrice = (TextView) findViewById(R.id.ticketPrice);
        TextView classPrice = (TextView) findViewById(R.id.classPrice);
        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);
        int ticketP = currFlight.getTicketPrice();
        int classP = currClassPrice;
        int total = ticketP + classP;
        ticketPrice.setText(ticketP + "");
        classPrice.setText(classP + "");
        totalPrice.setText(total + "");


        Button purchaseBtn = (Button) findViewById(R.id.btn_purchase);
        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cardNum = (EditText) findViewById(R.id.cardNum);
                EditText expiryDate = (EditText) findViewById(R.id.expiry_date);
                EditText securityCode = (EditText) findViewById(R.id.security_code);

                String card = cardNum.getText().toString();
                String date = expiryDate.getText().toString();
                String code = securityCode.getText().toString();
                TextView condition = (TextView) findViewById(R.id.condition);
                if(checkFormat(card,date,code)){
                    condition.setText("Purchase succeed");
                }
                else{
                    condition.setText("Purchase failed");
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
