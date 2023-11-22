package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    //back to introductory screen
    public void tointroductoryscreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //go to home screen
    public void tohomescreen(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
    //go to create account screen
    public void tocreateaccount(View view) {
        Intent intent = new Intent(this, CreateAccScreen.class);
        startActivity(intent);
    }


}