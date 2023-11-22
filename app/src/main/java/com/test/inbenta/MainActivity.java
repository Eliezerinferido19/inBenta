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

// to go to any screen <<<<
    public void tologin(View view) {
        Intent intent = new Intent(this,LoginScreen.class);
        startActivity(intent);
    }
    public void tocreateaccount(View view) {
        Intent intent = new Intent(this,CreateAccScreen.class);
        startActivity(intent);
    }
// end >>>>


// 49497F color code
}