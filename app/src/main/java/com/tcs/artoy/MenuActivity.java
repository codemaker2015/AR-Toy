package com.tcs.artoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    ImageButton btnBack = null;
    ImageButton[] btnItems = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Initialize variables
        btnBack = findViewById(R.id.btn_back_1);

        //ImageButton array for holding item related details
        btnItems = new ImageButton[6];
        btnItems[0] = findViewById(R.id.btn_car);
        btnItems[1] = findViewById(R.id.btn_bus);
        btnItems[2] = findViewById(R.id.btn_cycle);
        btnItems[3] = findViewById(R.id.btn_traffic);
        btnItems[4] = findViewById(R.id.btn_house);
        btnItems[5] = findViewById(R.id.btn_cat);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        for(ImageButton button : btnItems) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuActivity.this, ARVisualization.class);
                    intent.putExtra("itemName", getItemName(button));
                    startActivity(intent);
                }
            });
        }
    }

    //Returns name of the view as a string value
    private String getItemName(View view) {
        switch (view.getId()){
            case R.id.btn_car: return "car";
            case R.id.btn_bus: return "bus";
            case R.id.btn_cycle: return "cycle";
            case R.id.btn_traffic: return "traffic";
            case R.id.btn_house: return "house";
            case R.id.btn_cat: return "cat";
            default: return "";
        }
    }
}