package com.group8.backspace.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.group8.backspace.R;

public class TravelClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_class);

        Button btn_TravelClassSelected = findViewById(R.id.btn_purchase);
        btn_TravelClassSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(0!=onRadioButtonClicked(v))
                {
                    startActivity(new Intent(TravelClass.this, PurchaseTicket.class));
                }
            }
        });
    }

    // probably need to change this...
    public int onRadioButtonClicked(View view) {
        // Is the button now checked?
        if(!((RadioButton) view).isChecked())
            return 0;

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_Poor:
                return 1;// Poor class selected
            case R.id.radio_Rich:
                return 2;// Rich class selected
        }
        return 0;
    }
}
