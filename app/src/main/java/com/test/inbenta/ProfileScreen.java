package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileScreen extends AppCompatActivity {
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
        startActivity(intent);
        finish();

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