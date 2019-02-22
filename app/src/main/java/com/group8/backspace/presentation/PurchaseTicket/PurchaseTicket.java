package com.group8.backspace.presentation.PurchaseTicket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.CalculatePrice;
import com.group8.backspace.logic.CheckCard;
import com.group8.backspace.logic.CheckDiscountCode;
import com.group8.backspace.objects.Flight;

public class PurchaseTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);


        //get the flight object selected via the flightNum passed by BookBrowseActivity
        int currFlightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
        int currClassPrice = getIntent().getIntExtra("Class_Price", 0);

        TextView flightNum = (TextView) findViewById(R.id.flight_view);
        String flightTitle = "Flight #"+currFlightNum;
        flightNum.setText(flightTitle);

        //calculate total price
        TextView ticketPrice = (TextView) findViewById(R.id.ticketPrice);
        TextView classPrice = (TextView) findViewById(R.id.classPrice);
        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);


        CalculatePrice total = new CalculatePrice(currFlightNum,currClassPrice);

        ticketPrice.setText(total.getTicketPrice() + "");
        classPrice.setText(total.getClassPrice() + "");
        totalPrice.setText(total.getTotalPrice() + "");
        final int totalP = total.getTotalPrice();
        Button checkCode = (Button) findViewById(R.id.btn_code);
        checkCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText discountCode = (EditText) findViewById(R.id.code);
                TextView newP = (TextView) findViewById(R.id.newPrice);
                int price = totalP;
                String code = discountCode.getText().toString();
                CheckDiscountCode check = new CheckDiscountCode(code, price);
                double newPrice = check.checkCode();
                if(newPrice!=0){
                    newP.setText("new price($): "+newPrice+"");
                }
                else{
                    newP.setText("Sorry, the code is invalid!");
                }
            }
        });




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
                CheckCard check = new CheckCard(card, date, code);
                if(check.checkFormat(card,date,code)){
                    condition.setText("Purchase succeed");
                }
                else{
                    condition.setText("Purchase failed");
                }

            }
        });
    }

}