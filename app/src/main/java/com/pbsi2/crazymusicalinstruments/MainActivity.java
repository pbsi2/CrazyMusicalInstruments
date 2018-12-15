package com.pbsi2.crazymusicalinstruments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static MediaPlayer instrumentPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView guitars = findViewById(R.id.guitars);
        guitars.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open
                Toast.makeText(getApplicationContext(), "Wow Guitars", Toast.LENGTH_LONG).show();
                Intent guitarsIntent = new Intent(MainActivity.this, GuitarsActivity.class);

                // Start the new activity
                startActivity(guitarsIntent);
            }
        });

        TextView keyboards = findViewById(R.id.keyboards);
        keyboards.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open
                Toast.makeText(getApplicationContext(), "Wow Keyboards", Toast.LENGTH_LONG).show();
                Intent keyboardsIntent = new Intent(MainActivity.this, KeyboardsActivity.class);

                // Start the new activity
                startActivity(keyboardsIntent);
            }
        });

        TextView percussions = findViewById(R.id.percussions);
        percussions.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open
                Toast.makeText(getApplicationContext(), "Wow Drums", Toast.LENGTH_LONG).show();
                Intent percussionsIntent = new Intent(MainActivity.this, PercussionsActivity.class);

                // Start the new activity
                startActivity(percussionsIntent);
            }
        });


    }
}
