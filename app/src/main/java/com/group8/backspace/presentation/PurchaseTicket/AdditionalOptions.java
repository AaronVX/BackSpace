package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.group8.backspace.R;
import com.group8.backspace.logic.AccessItems;
import com.group8.backspace.objects.Item;
import java.util.ArrayList;

public class AdditionalOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additionaloptions);

        AccessItems access = new AccessItems();

        final Item vrNYC = access.getItemByName("New York City");
        final Item vrWW = access.getItemByName("West World");
        final Item mealPaste = access.getItemByName("Food paste");
        final Item mealMeat = access.getItemByName("Irradiated meat");
        final Item mealDrinks = access.getItemByName("Dried drinks");

        TextView textNYCPrice =  findViewById(R.id.textNYCPrice);
        TextView textWWPrice =  findViewById(R.id.textWWPrice);
        TextView textPastePrice =  findViewById(R.id.textPastePrice);
        TextView textMeatPrice =  findViewById(R.id.textMeatPrice);
        TextView textDrinksPrice =  findViewById(R.id.textDrinksPrice);

        textNYCPrice.setText(vrNYC.getPrice()+"$");
        textWWPrice.setText(vrWW.getPrice()+"$");
        textPastePrice.setText(mealPaste.getPrice()+"$");
        textMeatPrice.setText(mealMeat.getPrice()+"$");
        textDrinksPrice.setText(mealDrinks.getPrice()+"$");


        Button btn_book = findViewById(R.id.btn_purchase);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkNYC = findViewById(R.id.checkNYC);
                CheckBox checkWW = findViewById(R.id.checkWW);
                CheckBox checkPaste= findViewById(R.id.checkPaste);
                CheckBox checkMeat= findViewById(R.id.checkMeat);
                CheckBox checkDrinks= findViewById(R.id.checkDrinks);

                int itemsPrice = 0;
                if(checkNYC.isChecked())
                    itemsPrice+=vrNYC.getPrice();
                if(checkWW.isChecked())
                    itemsPrice+=vrWW.getPrice();
                if(checkPaste.isChecked())
                    itemsPrice+=mealPaste.getPrice();
                if(checkMeat.isChecked())
                    itemsPrice+= mealMeat.getPrice();
                if(checkDrinks.isChecked())
                    itemsPrice+=mealDrinks.getPrice();

                int flightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
                //need a method to set class price
                int classPrice = getIntent().getIntExtra("Class_Price", 0);
                classPrice += itemsPrice;
                Intent detailIntent = new Intent(AdditionalOptions.this, PurchaseTicket.class);
                detailIntent.putExtra("FLIGHT_NUM", flightNum);
                detailIntent.putExtra("Class_Price", classPrice);
                //detailIntent.putExtra("Items_Price", itemsPrice);
                startActivity(detailIntent);
            }
        });
    }
}
