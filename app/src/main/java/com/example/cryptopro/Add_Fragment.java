package com.example.cryptopro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Add_Fragment extends Fragment {



    EditText ed1;

    Button Addmoney_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.addmoney, container, false);
        ed1=view.findViewById(R.id.addmoneytext);

        Addmoney_button=view.findViewById(R.id.Addmoney_button);

        Addmoney_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return  view;
    }
}