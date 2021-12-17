package com.example.oma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ProfessionalFragment extends Fragment {

    Spinner chooseProfessionsS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_professional, container, false);

        chooseProfessionsS = view.findViewById(R.id.chooseProfessionS);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.professions,R.layout.support_simple_spinner_dropdown_item);
        chooseProfessionsS.setAdapter(adapter);

//        return inflater.inflate(R.layout.fragment_professional, container, false);
        return view;
    }
}