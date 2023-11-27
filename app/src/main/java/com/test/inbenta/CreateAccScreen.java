package com.test.inbenta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class CreateAccScreen extends AppCompatActivity {

    EditText EditTextusername, EditTextpassword, EditTextpasswordConfirm;
    Button buttoncreateacc;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(intent);
            finish();

        }
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc_screen);
        mAuth = FirebaseAuth.getInstance();
        EditTextusername = findViewById(R.id.username);
        EditTextpassword = findViewById(R.id.password);
        EditTextpasswordConfirm = findViewById(R.id.passwordConfirm);
        buttoncreateacc = findViewById(R.id.btn_create_account);
        progressBar = findViewById(R.id.progressBar);

        buttoncreateacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                // Get the entered passwords
                String username = String.valueOf(EditTextusername.getText());
                String email = username + "@gmail.com";
                String password = String.valueOf(EditTextpassword.getText());
                String passwordConfirm = String.valueOf(EditTextpasswordConfirm.getText());
                //email = username + "@gmail.com";

                //if empty
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(CreateAccScreen.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(CreateAccScreen.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordConfirm)){
                    Toast.makeText(CreateAccScreen.this, "Enter Password Confirm", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals(passwordConfirm)) {
                    // Check if passwords match
                    //firebase
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(CreateAccScreen.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(CreateAccScreen.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                } else {
                    // Passwords do not match, show an error message
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(CreateAccScreen.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    // back to introductory screen
    public void tointroductoryscreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //to login screen
    public void tologin(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}