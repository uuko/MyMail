package com.example.mymail;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        SystemClock.sleep(3000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        Log.d("333", "onStart: "+currentUser);
        if (currentUser ==null){
            Intent register_intent=new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(register_intent);
            finish();
        }else {
            Intent main_intent=new Intent(MainActivity.this,SplashActivity.class);
            startActivity(main_intent);
            finish();
        }
    }
}
