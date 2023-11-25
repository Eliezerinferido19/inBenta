package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SellScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_screen);
    }

    //Menu option start
    //to Home screen
    public void tohomescreen(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
    //to Restock screen
    public void torestockscreen(View view) {
        Intent intent = new Intent(this, RestockScreen.class);
        startActivity(intent);
    }
    //to Sell screen
    public void tosellscreen(View view) {
        Intent intent = new Intent(this, SellScreen.class);
        startActivity(intent);
    }
    //to Stock screen
    public void tostockscreen(View view) {
        Intent intent = new Intent(this, StockScreen.class);
        startActivity(intent);
    }
    //to Profile screen
    public void toprofilescreen(View view) {
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }
    // Menu option end >>>
}