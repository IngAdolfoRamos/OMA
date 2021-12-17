package com.example.oma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewConsultationActivity extends AppCompatActivity {

    Spinner chooseProfessionsS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_consultation);

        connectUI();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.professions,R.layout.support_simple_spinner_dropdown_item);
        chooseProfessionsS.setAdapter(adapter);

    }

    public void connectUI(){
        chooseProfessionsS = findViewById(R.id.chooseProfessionS);
    }
}