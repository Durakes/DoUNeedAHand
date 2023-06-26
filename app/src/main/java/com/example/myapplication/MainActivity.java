package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    Button signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText);
        loginButton.setOnClickListener(view -> {
            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                Toast.makeText(MainActivity.this, "Logeado correctamente!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,Servicio.class);
                startActivity(i);

            } else {
                Toast.makeText(MainActivity.this, "Contraseña Incorrecta!", Toast.LENGTH_SHORT).show();
            }
        });

        signupText.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Llena los datos!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,Bienvenida.class));
        });
    }

}