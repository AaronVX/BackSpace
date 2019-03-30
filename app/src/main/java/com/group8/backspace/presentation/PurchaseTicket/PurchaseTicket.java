package com.group8.backspace.presentation.PurchaseTicket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.CalculatePrices;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.logic.CheckCard;
import com.group8.backspace.logic.CheckCoupon;

public class PurchaseTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);


        //get the flight object selected via the flightNum passed by BookBrowseActivity
        int currFlightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
//        int currClassPrice = getIntent().getIntExtra("Class_Price", 0);
//        int currItemsPrice = getIntent().getIntExtra("Items_Price", 0);

        TextView flightNum = (TextView) findViewById(R.id.flight_view);
        String flightTitle = "Flight #"+currFlightNum;
        flightNum.setText(flightTitle);

        //calculate total price
//        TextView fuelPrice = (TextView) findViewById(R.id.ticketPrice);
//        TextView classPrice = (TextView) findViewById(R.id.classPrice);
        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);
//
//        AccessFlights flightAccessor =  new AccessFlights(Services.getFlightPersistence());
//        Flight currFlight = flightAccessor.getFlightByID(currFlightNum);
//        CalculatePrices total = new CalculatePrices(currFlight,currClassPrice,currItemsPrice,Services.getPlanetPersistence());
//        total.calculatePrice();
//        fuelPrice.setText(Integer.toString(total.getTicketPrice()));
//        classPrice.setText(Integer.toString(total.getExtraExpense()));
//        totalPrice.setText(Integer.toString(total.getTotalPrice()));
//        final int totalP = total.getTotalPrice();

        int totalP = getIntent().getIntExtra("Total_Price", 0);
        totalPrice.setText(Integer.toString(totalP));

        Button checkCode = (Button) findViewById(R.id.btn_code);
        checkCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText discountCode = (EditText) findViewById(R.id.code);
                TextView newP = (TextView) findViewById(R.id.newPrice);
                int price = totalP;
                String code = discountCode.getText().toString();
                CheckCoupon check = new CheckCoupon(code, price);
                if(check.checkCode()){
                    newP.setText("new price($): "+check.getDiscount()+"");
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
                CheckCard check = new CheckCard();
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
