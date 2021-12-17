package com.example.oma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loginB, passwordRecoverB, registerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectUI();

        passwordRecoverB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPasswordRecoverView();
            }
        });

        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterUserView();
            }
        });

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPacientHome();
            }
        });

    }

    public void connectUI(){
        loginB = findViewById(R.id.loginB);
        passwordRecoverB = findViewById(R.id.passwordRecoverB);
        registerB = findViewById(R.id.registerB);
    }

    public void goToPasswordRecoverView(){
        Intent goPasswordRecoverActivity = new Intent(this, PasswordRecover.class);
        startActivity(goPasswordRecoverActivity);
    }

    public void goToPacientHome(){
        Intent intent = new Intent(this, PacientHomeActivity.class);
        startActivity(intent);
    }

    public void goToRegisterUserView(){
        Intent goToRegisterUserView = new Intent(this, RegisterUser.class);
        startActivity(goToRegisterUserView);
    }
}