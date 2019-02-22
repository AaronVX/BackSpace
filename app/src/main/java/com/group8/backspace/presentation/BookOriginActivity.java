package com.group8.backspace.presentation;

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
        // unimplemented planets (no xml images)
        // findViewById(R.id.btn_moon).setOnClickListener(this);
        // findViewById(R.id.btn_mars).setOnClickListener(this);
        // findViewById(R.id.btn_jupiter).setOnClickListener(this);
        // findViewById(R.id.btn_saturn).setOnClickListener(this);
        // findViewById(R.id.btn_uranus).setOnClickListener(this);
        // findViewById(R.id.btn_neptune).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BookOriginActivity.this, BookDestinationActivity.class);
        intent.putExtra("origin", (String) v.getTag());
        startActivity(intent);
    }

}
