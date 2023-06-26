package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class SiguientePantalla extends AppCompatActivity implements View.OnClickListener {

    Button bfecha, bhora;
    EditText efecha, ehora;
    private int dia,mes,ano,hora,minutos;
    Button siguiente;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siguiente_pantalla);
        bfecha =findViewById(R.id.bfecha);
        bhora = findViewById(R.id.bhora);
        efecha = findViewById(R.id.efecha);
        ehora = findViewById(R.id.ehora);
        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
        siguiente = findViewById(R.id.siguiente);
        siguiente.setOnClickListener(view -> {
            startActivity(new Intent(SiguientePantalla.this,Resumen.class));
        });
    }
    @Override
    public void onClick(View view) {

        if(view==bfecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMoth) {
                    efecha.setText(dayOfMoth+"/"+(monthOfYear+1)+"/"+year);
                }
            },dia,mes,ano);
            datePickerDialog.show();
        }
        if(view==bfecha){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    ehora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }

}