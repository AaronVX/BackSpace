package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.application.Services;
import com.group8.backspace.logic.AccessFlights;
import com.group8.backspace.logic.AccessPlanets;
import com.group8.backspace.logic.AnalyseFlight;
import com.group8.backspace.logic.CalculatePrices;
import com.group8.backspace.objects.Flight;
import com.group8.backspace.presentation.DateHandler;

import net.bytebuddy.implementation.bytecode.Addition;

// seekBar usage example...
// https://stackoverflow.com/questions/8629535/implementing-a-slider-seekbar-in-android

public class BookReview extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_review);

        // find buttons
        Button btn_origin = findViewById(R.id.btn_origin);
        Button btn_destination = findViewById(R.id.btn_destination);
        Button btn_travel_class = findViewById(R.id.btn_travel_class);
        Button btn_purchase = findViewById(R.id.btn_purchase);
        Button btn_additional_days = findViewById(R.id.btn_additional_days);

        // find texts
        TextView origin_name = findViewById(R.id.origin_name);
        TextView destination_name = findViewById(R.id.destination_name);
        TextView items_price = findViewById(R.id.items_price);
        TextView fuel_price = findViewById(R.id.fuel_price);
        TextView class_price = findViewById(R.id.class_price);

        // find seekBar
        SeekBar seekBar = findViewById(R.id.seekBarDays);

        // get intents
        String className = getIntent().getStringExtra("Class_Name");
        int currFlightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
        int dailyClassPrice = getIntent().getIntExtra("Class_Price", 0);
        int dailyItemsPrice = getIntent().getIntExtra("Items_Price", 0);

        if(className.equals("hyper sleep") || dailyItemsPrice == 0){
            LinearLayout hide1 = findViewById(R.id.layout_daily_expenses);
            SeekBar hide2 = findViewById(R.id.seekBarDays);
            View hide3 = findViewById(R.id.divider2);
            hide1.setVisibility(View.GONE);
            hide2.setVisibility(View.GONE);
            hide3.setVisibility(View.GONE);
        }

        // setup accessors
        AccessFlights flightAccessor =  new AccessFlights(Services.getFlightPersistence());
        Flight currFlight = flightAccessor.getFlightByID(currFlightNum);

        AnalyseFlight analyseFlight = new AnalyseFlight(currFlight, Services.getPlanetPersistence());
        analyseFlight.analyse();

        CalculatePrices prices = new CalculatePrices(analyseFlight.getDistance(),
                analyseFlight.getDuration(),dailyClassPrice,dailyItemsPrice);

        AccessPlanets pAccess = new AccessPlanets(Services.getPlanetPersistence());
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
        prices.setPrepaidDays(progress);


        // put relevant info
        String name = currFlight.getOrigin();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        origin_name.setText(name);

        name = currFlight.getDestination();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        destination_name.setText(name);

        // set prices
        btn_travel_class.setText("Days: "+analyseFlight.getDuration());
        btn_purchase.setText(prices.calculateTotalPrice() + " $");
        items_price.setText(prices.calculatePrepaidPrice()+" $");
        class_price.setText(prices.calculateClassPrice()+ " $");
        fuel_price.setText(prices.calculateFuelPrice() + " $");
        btn_additional_days.setText("Days: " + prices.getPrepaidDays());


        // react to changes
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // updated continuously as the user slides the thumb
                prices.setPrepaidDays(progress);
                items_price.setText(prices.calculatePrepaidPrice()+" $");
                btn_additional_days.setText("Days: " + prices.getPrepaidDays());
                btn_purchase.setText(prices.calculateTotalPrice() + " $");
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

        // transitions
        btn_origin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookReview.this, BookOriginActivity.class));
            }
        });
        btn_destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(BookReview.this, BookDestinationActivity.class);
                next.putExtra("origin", currFlight.getOrigin());
                startActivity(next);
            }
        });
        btn_travel_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(BookReview.this, TravelClass.class);
                next.putExtra("FLIGHT_NUM", currFlightNum);
                startActivity(next);
            }
        });

        btn_additional_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(BookReview.this, AdditionalOptions.class);
                next.putExtra("FLIGHT_NUM", currFlightNum);
                next.putExtra("Class_Name", getIntent().getStringExtra("Class_Name"));
                next.putExtra("Class_Price", getIntent().getStringExtra("Class_Price"));
                startActivity(next);
            }
        });

        btn_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(BookReview.this, PurchaseTicket.class);
                next.putExtra("FLIGHT_NUM", currFlightNum);
                next.putExtra("Total_Price", prices.calculateTotalPrice());
                next.putExtra("Ticket_Price",prices.calculateFuelPrice());
                next.putExtra("Extra",prices.calculateClassPrice()+prices.calculatePrepaidPrice());
                startActivity(next);
            }
        });
    }



}
