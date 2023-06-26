package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {


    EditText name;
    EditText email;
    EditText passwordRe;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        passwordRe = findViewById(R.id.passwordRe);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Bienvenida.this, "Registro Exitoso!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent( Bienvenida.this,MainActivity.class));
            }
        });
    }
}