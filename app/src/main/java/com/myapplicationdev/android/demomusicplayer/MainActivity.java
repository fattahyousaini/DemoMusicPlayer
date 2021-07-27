package com.myapplicationdev.android.demomusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(MainActivity.this, permission, 0);

        start = findViewById(R.id.btnStart);
        stop = findViewById(R.id.btnStop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // starting the service
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stopping the service
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });

    }
}