package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    // onClick method for Facebook icon
    public void onFacebookIconClicked(View view) {
        // Open Facebook URL in a browser
        openUrlInBrowser("https://web.facebook.com/ssfmsa/?_rdc=1&_rdr");
    }

    // onClick method for Twitter icon
    public void onTwitterIconClicked(View view) {
        // Open Twitter URL in a browser
        openUrlInBrowser("https://twitter.com/SouthsidefmR");
    }

    // onClick method for Instagram icon
    public void onInstagramIconClicked(View view) {
        // Open Instagram URL in a browser
        openUrlInBrowser("https://www.instagram.com/southsidefmsa");
    }

    // onClick method for WhatsApp icon
    public void onWhatsappIconClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://api.whatsapp.com/send?phone=27743454447");
    }

    // onClick method for WhatsApp icon
    public void onLinkedinIconClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://www.linkedin.com/company/southside-fm-south-africa/");
    }

    // onClick method for WhatsApp icon
    public void onTikIconClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://www.tiktok.com/@southsidesfmsa");
    }

    // onClick method for YouTube icon
    public void onYouTubeClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://www.youtube.com/@southsidefmsa107.2");
    }

    // onClick method for YouTube icon
    public void onWebsiteIconClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://southsidefm.com/");
    }


    // onClick method for Back icon
    public void onBackIconClicked(View view) {
        // Open website URL in a browser
        startActivity(new Intent(About.this, Home.class));
    }

    // onClick method for Email icon
    public void onMailIconClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"admin@southsidefm.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Body");
        intent.setPackage("com.google.android.gm"); // Set package to Gmail
        startActivity(intent);
    }

    private void openUrlInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}