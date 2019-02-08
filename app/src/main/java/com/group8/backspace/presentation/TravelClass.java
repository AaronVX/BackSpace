package com.group8.backspace.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.group8.backspace.R;

public class TravelClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_class);

        Button btn_Purchase = (Button) findViewById(R.id.btn_purchase);
        btn_Purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TravelClass.this, PurchaseTicket.class));
            }
        });
    }
}
