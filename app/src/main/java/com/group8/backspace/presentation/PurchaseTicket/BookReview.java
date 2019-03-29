package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.logic.AccessPrice;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.DateHandler;

// seekBar usage example...
// https://stackoverflow.com/questions/8629535/implementing-a-slider-seekbar-in-android

public class BookReview extends AppCompatActivity{

    // TODO, too much code duplication... Probably need a session object
    // TODO, use DateHandler
    // TODO, fix transition to PurchaseTicket page
    // TODO, add a tooltip

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_review);

        // find buttons
        Button btn_origin = findViewById(R.id.btn_origin);
        Button btn_destination = findViewById(R.id.btn_destination);
        Button btn_travel_class = findViewById(R.id.btn_travel_class);
        Button btn_purchase = findViewById(R.id.btn_purchase);

        // find texts
        TextView origin_name = findViewById(R.id.origin_name);
        TextView destination_name = findViewById(R.id.destination_name);
        TextView items_price = findViewById(R.id.items_price);
        TextView fuel_price = findViewById(R.id.fuel_price);
        TextView additional_days = findViewById(R.id.additional_days);

        // find seekBar
        SeekBar seekBar = findViewById(R.id.seekBarDays);

        // setup listeners
        btn_origin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookReview.this, BookOriginActivity.class));

            }
        });
        btn_destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookReview.this, BookDestinationActivity.class));

            }
        });
        btn_travel_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookReview.this, TravelClass.class));

            }
        });
        btn_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookReview.this, PurchaseTicket.class));

            }
        });

        String className = getIntent().getStringExtra("Class_Name");
        if(className.equals("hyper sleep")){
            LinearLayout hide1 = findViewById(R.id.layout_daily_expenses);
            SeekBar hide2 = findViewById(R.id.seekBarDays);
            View hide3 = findViewById(R.id.divider2);
            hide1.setVisibility(View.GONE);
            hide2.setVisibility(View.GONE);
            hide3.setVisibility(View.GONE);
        }


        // get intents
        int currFlightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
        int basicClassPrice = getIntent().getIntExtra("Class_Price", 0);
        int basicItemsPrice = getIntent().getIntExtra("Items_Price", 0);

        // setup accessors
        AccessFlights flightAccessor =  new AccessFlights();
        Flight currFlight = flightAccessor.getFlightByID(currFlightNum);
        AccessPrice priceAccessor = new AccessPrice(currFlight,basicClassPrice,basicItemsPrice);
        AccessPlanets pAccess = new AccessPlanets();
        DateHandler handleDates = new DateHandler(currFlight.getDeparture(), currFlight.getArrival());

        //get the image sources from the flight object
        String originSrc = pAccess.getPlanetByName(currFlight.getOrigin()).getImgSrc();
        String destinationSrc = pAccess.getPlanetByName(currFlight.getDestination()).getImgSrc();
        int resID;
        resID = getResources().getIdentifier(originSrc , "drawable", getPackageName());
        btn_origin.setCompoundDrawablesWithIntrinsicBounds(0, resID, 0, 0);
        resID = getResources().getIdentifier(destinationSrc , "drawable", getPackageName());
        btn_destination.setCompoundDrawablesWithIntrinsicBounds(0, resID, 0, 0);

        //use the date handler to get nice strings for textviews

        String dates[] = handleDates.getStrings(); // TODO, Dependency inversion.. I need to know indexes of the dates
        btn_origin.setText(dates[0]);
        btn_destination.setText(dates[1]);
        //totalTime.setText(handleDates.getTravelTime());

        int progress = seekBar.getProgress();
        priceAccessor.setPrepaidPercentage(progress);
        // Dependency inversion issue
        // "prices" need to know that "progress" is from 0 to 100.
        // Not sure how to solve this...


        // put relevant info
        String name = currFlight.getOrigin();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        origin_name.setText(name);

        name = currFlight.getDestination();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        destination_name.setText(name);

        btn_travel_class.setText("Days: "+priceAccessor.getTotalDuration());
        btn_purchase.setText(priceAccessor.getTotalPrice() + " $");
        items_price.setText(priceAccessor.getItemsPrice()+" $");
        fuel_price.setText(priceAccessor.getFuelPrice() + " $");
        additional_days.setText("Days: " + priceAccessor.getPrepaidDays());


        // react to changes
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // updated continuously as the user slides the thumb
                priceAccessor.setPrepaidPercentage(progress);
                items_price.setText(priceAccessor.getItemsPrice()+" $");
                additional_days.setText("Days: " + priceAccessor.getPrepaidDays());
                btn_purchase.setText(priceAccessor.getTotalPrice() + " $");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // called when the user first touches the SeekBar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // called after the user finishes moving the SeekBar
            }
        };
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
    }



}
