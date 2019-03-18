package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.group8.backspace.R;

public class BookOriginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_origin);

        findViewById(R.id.btn_mercury).setOnClickListener(this);
        findViewById(R.id.btn_venus).setOnClickListener(this);
        findViewById(R.id.btn_earth).setOnClickListener(this);
        // findViewById(R.id.btn_moon).setOnClickListener(this);
         findViewById(R.id.btn_mars).setOnClickListener(this);
         findViewById(R.id.btn_jupiter).setOnClickListener(this);
         findViewById(R.id.btn_saturn).setOnClickListener(this);
         findViewById(R.id.btn_uranus).setOnClickListener(this);
         findViewById(R.id.btn_neptune).setOnClickListener(this);
        findViewById(R.id.btn_pluto).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(getIntent().getStringExtra("destination") != null) {
            Intent intent = new Intent(BookOriginActivity.this, BookBrowseActivity.class);
            intent.putExtra("origin", (String) v.getTag());
            intent.putExtra("destination", getIntent().getStringExtra("destination"));
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(BookOriginActivity.this, BookDestinationActivity.class);
            intent.putExtra("origin", (String) v.getTag());
            startActivity(intent);
        }
    }

}
