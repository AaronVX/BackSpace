package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.group8.backspace.R;

public class AdditionalOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additionaloptions);

        Button btn_book = findViewById(R.id.btn_purchase);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
                //need a method to set class price
                int classPrice = getIntent().getIntExtra("Class_Price", 0);
                Intent detailIntent = new Intent(AdditionalOptions.this, PurchaseTicket.class);
                detailIntent.putExtra("FLIGHT_NUM", flightNum);
                detailIntent.putExtra("Class_Price", classPrice);
                startActivity(detailIntent);
            }
        });
    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_none:
//                if (checked)
//                    break;
//            case R.id.radio_nyc:
//                if (checked)
//                    break;
//            case R.id.radio_ww:
//                if (checked)
//                    break;
//        }
//    }

}
