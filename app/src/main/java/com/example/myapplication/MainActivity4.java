package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    EditText et_subject, et_message;
    Button btn, btn1, livebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        // Get reference to the back button

        livebtn = findViewById(R.id.liveVideoButton);

        et_subject = findViewById(R.id.edit_subject);
        et_message = findViewById(R.id.email_message);

        btn = findViewById(R.id.email_send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = et_subject.getText().toString().trim();
                String message = et_message.getText().toString().trim();
                String email = "Onair@southsidefm.com";

                if(subject.isEmpty())
                {
                    Toast.makeText(MainActivity4.this,  "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if (message.isEmpty())
                {
                    Toast.makeText(MainActivity4.this,  "Please add some Message", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String mail = "mailto: "    + email +
                                  "?&subject="  + Uri.encode(subject) +
                                  "&body="      + Uri.encode(message);

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse(mail));

                    try
                    {
                        startActivity(Intent.createChooser(intent, "Send Email..."));
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(MainActivity4.this,  "Exception: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create an Intent to navigate to the new activity
                        Intent intent = new Intent(MainActivity4.this, Home.class);

                        // Start the new activity
                        startActivity(intent);
                    }
                });
            }
        });

    }
    // onClick method for WhatsApp icon
    public void onliveVideoClicked(View view) {
        // Open website URL in a browser
        openUrlInBrowser("https://web.facebook.com/ssfmsa/?_rdc=1&_rdr");
    }

    private void openUrlInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    // onClick method for Back icon
    public void onBackIconClicked(View view) {
        // Open website URL in a browser
        startActivity(new Intent(MainActivity4.this, Home.class));
    }
}