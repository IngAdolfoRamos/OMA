package com.example.oma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PasswordRecover extends AppCompatActivity {

    Button passwordRecoverB;
    TextView passwordRecoverTTV;
    TextView passwordRecoverBTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recover);

        connectUI();

        passwordRecoverTTV.setVisibility(View.INVISIBLE);
        passwordRecoverBTV.setVisibility(View.INVISIBLE);

        passwordRecoverB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmation();
            }
        });


    }

    public void connectUI(){
        passwordRecoverB = findViewById(R.id.passwordRecoverB);
        passwordRecoverTTV = findViewById(R.id.passwordRecoverTTV);
        passwordRecoverBTV = findViewById(R.id.passwordRecoverBTV);
    }

    public void showConfirmation(){
        passwordRecoverTTV.setVisibility(View.VISIBLE);
        passwordRecoverBTV.setVisibility(View.VISIBLE);
    }
}