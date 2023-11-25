package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StockEditScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_edit_screen);
    }
    //to Back_btn Stock screen
    public void tostockscreen(View view) {
        Intent intent = new Intent(this, StockScreen.class);
        startActivity(intent);
    }

}