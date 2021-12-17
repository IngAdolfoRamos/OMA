package com.example.oma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PacientHomeActivity extends AppCompatActivity {

    Button newConsultationB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacient_home);

        connectUI();

        newConsultationB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewConsultationActivity();
            }
        });

    }

    public void goToNewConsultationActivity() {
        Intent intent = new Intent(this, NewConsultationActivity.class);
        startActivity(intent);

    }

    public void connectUI(){
        newConsultationB = findViewById(R.id.newConsultationB);
    }
}