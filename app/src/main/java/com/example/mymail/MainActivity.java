package com.example.mymail;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemClock.sleep(3000);
        Intent login_intent=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(login_intent);
        finish();
    }
}
