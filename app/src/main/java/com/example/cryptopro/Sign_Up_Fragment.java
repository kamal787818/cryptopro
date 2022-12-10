package com.example.cryptopro;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.Edits;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Sign_Up_Fragment extends Fragment {
Button signUpBtn;
EditText ed1,ed2,ed3,ed4,ed5,ed6;
SharedPreferences preferences;
RequestQueue requestQueue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign__up_, container, false);
       signUpBtn=view.findViewById(R.id.signUpBtn);
        ed1=view.findViewById(R.id.fullName);
        ed2=view.findViewById(R.id.email);
        ed3=view.findViewById(R.id.pass);
        ed6=view.findViewById(R.id.mob);
        ed4=view.findViewById(R.id.phn);
        ed5 =view.findViewById(R.id.gender);
       requestQueue=Volley.newRequestQueue(getContext());

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ed1.getText().toString();
                String email=ed2.getText().toString();
                String pass=ed3.getText().toString();
                String phone=ed4.getText().toString();
                String addr=ed6.getText().toString();
                String gender=ed5.getText().toString();


                //                startActivity(new Intent(getContext(),homeActivity.class));

                StringRequest stringRequest=new StringRequest(Request.Method.GET, "http://www.anpad.in/EkInvestment_API.asmx/register?name="+name+"&email="+email+"&pass="+pass+"&phn="+phone+"&add="+addr+"&grn="+gender+"", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        startActivity(new Intent(getContext(),homeActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "hhhh"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                });
                requestQueue.add(stringRequest);



            }
        });
        return view;
    }
}