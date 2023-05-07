package com.ashdev.tictactoegame;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import java.text.DateFormat;
import java.util.Calendar;


public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        LottieAnimationView splashanimation = findViewById(R.id.splashanimation);
        getSupportActionBar().hide();
        // Splash animation provider for feb and other month
        Calendar c = Calendar.getInstance();
        if(c.get(Calendar.MONTH) == Calendar.FEBRUARY){
            splashanimation.setAnimation(R.raw.splash_for_feb);
            splashanimation.playAnimation();
        }else {
            splashanimation.setAnimation(R.raw.splash2);
            splashanimation.playAnimation();
        }
        // Splash Activity handler
        new Handler().postDelayed(() -> {
            Intent isplash = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(isplash);
            finish();
        },4000);
    }
}