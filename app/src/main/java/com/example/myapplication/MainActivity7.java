package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.NewsApiResponse;
import com.example.myapplication.Models.NewsHeadlines;

import java.util.List;

public class MainActivity7 extends AppCompatActivity implements SelectListener, View.OnClickListener{

    RecyclerView recyclerView;
    CustomAdapter adapter;
    SearchView searchView;
    Button b1, b2, b3, b4, b5, b6, b7;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestManager manager = new RequestManager(MainActivity7.this);
                manager.getNewsHeadlines(listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity7.this, "An Error Occurred!!!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list)
    {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity7.this, MainActivity8.class)
                .putExtra("data", headlines));
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String category = button.getText().toString();
        dialog.setTitle("Fetching news articles of " + category);
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "category", null);

    }

    // onClick method for Music icon
    public void onMusicIconClicked(View view) {
        // Open Home Page
        startActivity(new Intent(MainActivity7.this, Home.class));
    }

    // onClick method for List icon
    public void onShowsIconClicked(View view) {
        // Open Schedule Page
        startActivity(new Intent(MainActivity7.this, Schedule.class));

    }

    // onClick method for Location Map icon
    public void onLocationIconClicked(View view) {
        // Open Location Map Page
        startActivity(new Intent(MainActivity7.this, MainActivity.class));
    }

    // onClick method for Weather icon
    public void onWeatherIconClicked(View view) {
        // Open Weather
        //startActivity(new Intent(MainActivity7.this, MainActivity5.class));
    }

    // onClick method for About Us icon
    public void onAboutUsClicked(View view) {
        // Open About Us Page
        startActivity(new Intent(MainActivity7.this, About.class));
    }

}