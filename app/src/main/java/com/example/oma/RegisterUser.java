package com.example.oma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegisterUser extends AppCompatActivity {

    Spinner spinner;
    PacientFragment pacientFragment;
    ProfessionalFragment professionalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        spinner = findViewById(R.id.chooseUserS);

        pacientFragment = new PacientFragment();
        professionalFragment = new ProfessionalFragment();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterUser.this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.fragments));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        setFragment(pacientFragment);
//                        parent.getItemAtPosition(position);
                        break;
                    case 1:
                        setFragment(professionalFragment);
//                        parent.getItemAtPosition(position);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}