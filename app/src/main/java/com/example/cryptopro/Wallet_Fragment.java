package com.example.cryptopro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Wallet_Fragment extends Fragment {
    ImageButton addmoney,withdraw;
    BottomNavigationView navigationView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_wallet_, container, false);
     addmoney=view.findViewById(R.id.add_money);
        navigationView=view.findViewById(R.id.bottom_nav);
     addmoney.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            // navigationView.setVisibility(view.GONE);
             getFragmentManager().beginTransaction().add(R.id.home_container,new Add_Fragment()).commit();

         }
     });
     return view;
    }
}

