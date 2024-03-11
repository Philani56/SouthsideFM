package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Schedule extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] data = {
                "The Big Breakfast Show with Meshantan & Thashriya Naidoo \nMonday to Friday 6h00 - 9h00",
                "The Brunch Vibe with Vijay & Yogambal \nMonday to Friday 9h00 - 12h00",
                "The Power Lunch with JK \nMonday to Friday 12h00 - 15h00",
                "The Real Drive with Kaalan Pillay \nMonday to Friday 15h00 - 18h00",
                "Money Matters with Joe Chetty \nMonday 19h00 to 20h00",
                "Southern Comfort with Robbie The Maestro \nMonday to Friday 21h00 - 00h00",

                "Ubuntu Pulse with Dr. G \nWednesday 19h00 to 20h00",
                "Doctor's Corner with Dr Prabashni Coopsamy \nThursday 19h00 - 20h00",
                "Friday Night Take Off with Sadha Govender \nFriday 19h00 - 22h00",

                "Weekend Visesham with Lalitha Sambasiva Kurukkal \nSaturdays 6h00 - 9h00",
                "Youth Unplugged with Vaathi Revathi Pillay \nSaturdays 9h00 - 12h00",
                "Telegu Top 20 with Elvin Tagat and Thashriya Naidoo \nSaturdays 12h00 - 15h00",
                "Centre Stage with Yovani Naidoo and Kaalan Pillay \nSaturdays 15h00 - 18h00",

                "Weekend Visesham with Lalitha Sambasiva Kurukkal \nSundays 6h00 - 9h00",
                "Sunday Morning Spice with the D-squared Ponnu's \nSundays 9h00 - 12h00",
                "Telegu Top 20 with Devan Nair \nSundays 12h00 - 15h00",
                "Sampradaya with Vijalumxi Balakrishna \nSundays 15h00 - 18h00",
                "Gospel Hour with Ev. Paddy Padayachee \nSundays 18h00 - 19h00",
                "The Chill with Alan Chetty \nSundays 19h00 - 20h00"

        };

        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    // onClick method for Radio icon
    public void onMusicIconClicked(View view) {
        // Open Radio Page
        startActivity(new Intent(Schedule.this, Home.class));

    }

    // onClick method for Weather icon
    public void onWeatherClicked(View view) {
        // Open Weather Page
        startActivity(new Intent(Schedule.this, MainActivity2.class));
    }

    // onClick method for News icon
    public void onNewsIconClicked(View view) {
        // Open News Page
        startActivity(new Intent(Schedule.this, MainActivity7.class));

    }

    // onClick method for About Us icon
    public void onAboutClicked(View view) {
        // Open News Page
        startActivity(new Intent(Schedule.this, About.class));

    }

    // onClick method for Facebook Live icon
    public void onShowsIconClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://web.facebook.com/ssfmsa/?_rdc=1&_rdr");
    }

    private void openUrlInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}