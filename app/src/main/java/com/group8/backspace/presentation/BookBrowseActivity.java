package com.group8.backspace.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.group8.backspace.R;

public class BookBrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_browse);


        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");


        // Update top images
        ImageView origin_view = (ImageView) findViewById(R.id.origin);
        origin_view.setImageResource(getResources().getIdentifier("ic_" + origin , "drawable", getPackageName()));
        ImageView destination_view = (ImageView) findViewById(R.id.destination);
        destination_view.setImageResource(getResources().getIdentifier("ic_" + destination , "drawable", getPackageName()));

        // TODO populate calendarview from database

        Button nextPage = (Button) findViewById(R.id.btn_nextPage);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookBrowseActivity.this, FlightDetailActivity.class));
            }
        });
    }
}
