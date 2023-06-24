package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siguiente = findViewById(R.id.siguiente);
        siguiente.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Servicio!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,Servicio.class));
        });
    }
}