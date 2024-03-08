package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class MainActivity8 extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_time, txt_detail, txt_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);


        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);


        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());

        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
    }

    // onClick method for Phone icon
    public void onMusicIconClicked(View view) {
        // Open Contact Us Page
        startActivity(new Intent(MainActivity8.this, MainActivity7.class));
    }

    // onClick method for Phone icon
    public void onPhoneClicked(View view) {
        // Open Contact Us Page
        // startActivity(new Intent(MainActivity8.this, MainActivity6.class));
    }

    // onClick method for Weather icon
    public void onWeatherIconClicked(View view) {
        // Open Weather Page
        startActivity(new Intent(MainActivity8.this, MainActivity7.class));
    }

    // onClick method for Back icon
    public void onBackIconClicked(View view) {
        // Open website URL in a browser
        startActivity(new Intent(MainActivity8.this, Home.class));
    }
}