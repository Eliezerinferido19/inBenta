package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StockScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_screen);

//        // In your activity or fragment
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//// Create an instance of your custom adapter and set it on the RecyclerView
//        MyAdapter adapter = new MyAdapter(data); // Create your own adapter by extending RecyclerView.Adapter
//        recyclerView.setAdapter(adapter);
    }






















////////////////////////
    public void toregisternewitem(View view) {
        Intent intent = new Intent(this, RegisterNewItem.class);
        startActivity(intent);
    }
    //to stock edit screen
    public void tostockeditscreen(View view) {
        Intent intent = new Intent(this, StockEditScreen.class);
        startActivity(intent);
    }
    public void toregisternewitemscreen(View view) {
        Intent intent = new Intent(this, RegisterNewItem.class);
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