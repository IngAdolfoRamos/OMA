package com.example.oma;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.logging.LoggingPermission;

public class PacientFragment extends Fragment {

    Button searchB, continueB;
    TextInputLayout nameTF, lastNameTF, secondLastNameTF, curpTF, birthPlaceTF, bornDateTF;
    String url, curp, key, urlAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pacient, container, false);

        searchB = view.findViewById(R.id.searchB);
        continueB = view.findViewById(R.id.continueB);
        nameTF = view.findViewById(R.id.nameTF);
        lastNameTF = view.findViewById(R.id.lastNameTF);
        secondLastNameTF = view.findViewById(R.id.secondLastNameTF);
        curpTF = view.findViewById(R.id.curpTF);
        bornDateTF = view.findViewById(R.id.bornDateTF);
        birthPlaceTF = view.findViewById(R.id.birthPlaceTF);

        nameTF.setEnabled(false);
        lastNameTF.setEnabled(false);
        secondLastNameTF.setEnabled(false);
        birthPlaceTF.setEnabled(false);
        bornDateTF.setEnabled(false);

        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url = "https://us-west4-arsus-production.cloudfunctions.net/curp?curp=";
                key = "&apiKey=fugAo5ySpkYBJ8i5FMkJMMkU9xX2";
                curp = curpTF.getEditText().getText().toString();

                urlAPI = url + curp + key;

                RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

                JsonObjectRequest req = new JsonObjectRequest(urlAPI, new JSONObject(),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    curpTF.setError(null);
                                    VolleyLog.v("Response:%n %s", response.toString(4));

                                    JSONObject obj = new JSONObject(response.toString());
                                    JSONArray jsonArray = new JSONArray();
                                    jsonArray.put(obj);

                                    nameTF.setHint(obj.getString("name"));
                                    lastNameTF.setHint(obj.getString("fatherName"));
                                    secondLastNameTF.setHint(obj.getString("motherName"));
                                    birthPlaceTF.setHint(obj.getString("birthday"));
                                    bornDateTF.setHint(obj.getString("birthState"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                        curpTF.setError("URL invalida");
                    }
                });

                requestQueue.add(req);
            }
        });

        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUseRInfoLoginActivity();
            }
        });

        return view;
    }

    public void goToUseRInfoLoginActivity(){
        Intent intent = new Intent(getActivity(), UserInfoLoginActivity.class);
        startActivity(intent);
    }

}