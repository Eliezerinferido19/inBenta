package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }





    //to today view sales screen
    public void totodayviewsalesscreen(View view) {
        Intent intent = new Intent(this, ViewSalesScreen.class);
        startActivity(intent);
    }
    //to week view sales screen
    public void toweekviewsalesscreen(View view) {
        Intent intent = new Intent(this, ViewSalesScreen.class);
        startActivity(intent);
    }
    //to month view sales screen
    public void tomonthviewsalesscreen(View view) {
        Intent intent = new Intent(this, ViewSalesScreen.class);
        startActivity(intent);
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