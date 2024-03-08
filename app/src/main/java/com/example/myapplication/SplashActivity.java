package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final int ANIMATION_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Get the logo image view
        ImageView logoImageView = findViewById(R.id.logoImageView);

        // Define the animation
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(createScalingAnimation());
        animationSet.addAnimation(createRotationAnimation());

        // Apply the animation to the logo image view
        logoImageView.startAnimation(animationSet);

        // Set a delay for the animation to finish
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity (e.g., MainActivity)
                Intent intent = new Intent(SplashActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, ANIMATION_DURATION);
    }

    private Animation createScalingAnimation() {
        Animation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(ANIMATION_DURATION);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        return scaleAnimation;
    }

    private Animation createRotationAnimation() {
        Animation rotationAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotationAnimation.setDuration(ANIMATION_DURATION);
        rotationAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        return rotationAnimation;
    }
}