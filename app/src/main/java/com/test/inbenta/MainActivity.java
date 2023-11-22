package com.test.inbenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //to login screen
    public void tologin(View view) {
        Intent intent = new Intent(this,LoginScreen.class);
        startActivity(intent);
    }
    //to create account screen
    public void tocreateaccount(View view) {
        Intent intent = new Intent(this,CreateAccScreen.class);
        startActivity(intent);
    }



// 49497F color scheme
}