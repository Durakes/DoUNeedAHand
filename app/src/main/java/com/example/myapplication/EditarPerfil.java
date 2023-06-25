package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class EditarPerfil extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button volver;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.TypeDocument, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        volver = findViewById(R.id.volverperfil);
        guardar = findViewById(R.id.guardar);

        volver.setOnClickListener(view -> {
            Toast.makeText(EditarPerfil.this, "", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(EditarPerfil.this,Servicio.class));
        });


        guardar.setOnClickListener(view -> {
            Toast.makeText(EditarPerfil.this, "Datos Guardados", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(EditarPerfil.this,Servicio.class));
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text  = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}