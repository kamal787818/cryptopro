package com.example.cryptopro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_screen_Activity extends AppCompatActivity {
ImageView img;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       // img=findViewById(R.id.imgsplash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
         //       animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splashanim);
           //     img.startAnimation(animation);

                Intent i = new Intent
               // startActivity(new Intent(Splash_screen_Activity.this, FragmentContainer.class));
                (getApplicationContext(), FragmentContainer.class);
                startActivity(i);
                finish();
               // overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }


        }, 3000);
    }
}