package com.example.teste_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Handler(getMainLooper()).postDelayed(() ->{
            finish();
            startActivity(new Intent(this,LoginActivity.class));
            }, 2000);

    }
}