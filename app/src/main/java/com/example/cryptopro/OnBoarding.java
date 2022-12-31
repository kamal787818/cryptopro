package com.example.cryptopro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class OnBoarding extends AppCompatActivity {
    Button btn;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_onboarding);
        btn=findViewById(R.id.onboardingbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
                btn.startAnimation(animation);
                startActivity(new Intent(OnBoarding.this, Splash_screen_Activity.class));
            }
        });
    }

}