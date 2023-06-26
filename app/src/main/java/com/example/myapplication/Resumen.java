package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Resumen extends AppCompatActivity {

    Button confirmar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        confirmar = findViewById(R.id.confirmar);
        confirmar.setOnClickListener(view -> {
            Toast.makeText(Resumen.this,"Servicio reservado",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Resumen.this,Servicio.class));
        });
    }
}