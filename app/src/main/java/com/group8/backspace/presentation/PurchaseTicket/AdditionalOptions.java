package com.group8.backspace.presentation.PurchaseTicket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

        final AccessItems access = new AccessItems();

        final Item nyc = access.getItemByName("New York City");
        final Item ww = access.getItemByName("West World");
        final Item paste = access.getItemByName("Food paste");
        final Item meat = access.getItemByName("Irradiated meat");
        final Item drinks = access.getItemByName("Dried drinks");

        final ArrayList<Item> items = new ArrayList();
        items.add(nyc);
        items.add(ww);
        items.add(paste);
        items.add(meat);
        items.add(drinks);

        final ArrayList<TextView> texts = new ArrayList();
        texts.add( (TextView) findViewById(R.id.textNYCPrice));
        texts.add( (TextView) findViewById(R.id.textWWPrice));
        texts.add( (TextView) findViewById(R.id.textPastePrice));
        texts.add( (TextView) findViewById(R.id.textMeatPrice));
        texts.add( (TextView) findViewById(R.id.textDrinksPrice));

        for (int i = 0; i < texts.size(); i++) {
            String changed = items.get(i).getPrice()+"$";
            texts.get(i).setText(changed);
        }

        Button btn_book = findViewById(R.id.btn_purchase);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ArrayList<Item> selectedItems = new ArrayList();
                if(( (CheckBox) findViewById(R.id.checkNYC)).isChecked()) {
                    selectedItems.add(nyc);
                }
                if(( (CheckBox) findViewById(R.id.checkWW)).isChecked()) {
                    selectedItems.add(ww);
                }
                if(( (CheckBox) findViewById(R.id.checkPaste)).isChecked()) {
                    selectedItems.add(paste);
                }
                if(( (CheckBox) findViewById(R.id.checkMeat)).isChecked()) {
                    selectedItems.add(meat);
                }
                if(( (CheckBox) findViewById(R.id.checkDrinks)).isChecked()) {
                    selectedItems.add(drinks);
                }

                int flightNum = getIntent().getIntExtra("FLIGHT_NUM", 0);
                int classPrice = getIntent().getIntExtra("Class_Price", 0);
                int itemsPrice = access.getTotalPrice(selectedItems);
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
