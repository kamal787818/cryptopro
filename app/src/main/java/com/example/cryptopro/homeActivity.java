package com.example.cryptopro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.nav_home);
        getSupportFragmentManager().beginTransaction().add(R.id.home_container, new Home_Fragment()).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new Home_Fragment()).commit();
                        return true;
                    case R.id.nav_wallet:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new Wallet_Fragment()).commit();
                        return true;
                    case R.id.nav_share:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new Refer_Earn_Fragment()).commit();
                        return true;
                }
                return true;
            }
        });
    }
}