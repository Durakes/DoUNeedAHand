package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Limpieza extends AppCompatActivity {

    private TextView contadorDormitorios;
    private Button mas;
    private Button menos;
    private Button resetear;
    private int contador;

    private TextView contadorSalas;
    private Button masSala;
    private Button menosSala;
    private Button resetearSala;
    private int contadorSala;

    private TextView contadorBaños;
    private Button masBaño;
    private Button menosBaño;
    private Button resetearBaño;
    private int contadorBaño;

    Button siguiente;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.menosDormitorio:
                    minusCounter();
                    break;
                case R.id.masDormitorio:
                    plusCounter();
                    break;
                case R.id.resetDormitorio:
                    initCounter();
                    break;
                case R.id.menosSalas:
                    minusCounterSala();
                    break;
                case R.id.masSalas:
                    plusCounterSala();
                    break;
                case R.id.resetSalas:
                    initCounterSala();
                    break;
                case R.id.menosBaño:
                    minusCounterBano();
                    break;
                case R.id.masBaño:
                    plusCounterBano();
                    break;
                case R.id.resetBaño:
                    initCounterBano();
                    break;
            }
        }
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limpieza);
        contadorDormitorios = (TextView) findViewById(R.id.numerodormitorio);
        mas = (Button) findViewById(R.id.masDormitorio);
        mas.setOnClickListener(clickListener);
        menos = (Button) findViewById(R.id.menosDormitorio);
        menos.setOnClickListener(clickListener);
        resetear = (Button) findViewById(R.id.resetDormitorio);
        resetear.setOnClickListener(clickListener);
        initCounter();


        contadorSalas = (TextView) findViewById(R.id.numeroSalas);
        masSala = (Button) findViewById(R.id.masSalas);
        masSala.setOnClickListener(clickListener);
        menosSala = (Button) findViewById(R.id.menosSalas);
        menosSala.setOnClickListener(clickListener);
        resetearSala = (Button) findViewById(R.id.resetSalas);
        resetearSala.setOnClickListener(clickListener);
        initCounterSala();

        contadorBaños = (TextView) findViewById(R.id.numeroBaño);
        masBaño = (Button) findViewById(R.id.masBaño);
        masBaño.setOnClickListener(clickListener);
        menosBaño = (Button) findViewById(R.id.menosBaño);
        menosBaño.setOnClickListener(clickListener);
        resetearBaño = (Button) findViewById(R.id.resetBaño);
        resetearBaño.setOnClickListener(clickListener);
        initCounterBano();
        siguiente = findViewById(R.id.siguiente);
        siguiente.setOnClickListener(view -> {
            Toast.makeText(Limpieza.this,"Siguiente Paso",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Limpieza.this,SiguientePantalla.class));
        });

    }

    private void initCounter(){
        contador = 0;
        contadorDormitorios.setText(contador + "");
    }
    private void plusCounter(){
        contador++;
        contadorDormitorios.setText(contador + "");
    }
    private void minusCounter(){
        contador--;
        contadorDormitorios.setText(contador +"");
    }

    private void initCounterSala(){
        contadorSala = 0;
        contadorSalas.setText(contadorSala + "");
    }
    private void plusCounterSala(){
        contadorSala++;
        contadorSalas.setText(contadorSala + "");
    }
    private void minusCounterSala(){
        contadorSala--;
        contadorSalas.setText(contadorSala +"");
    }
    private void initCounterBano(){
        contadorBaño= 0;
        contadorBaños.setText(contadorBaño + "");
    }
    private void plusCounterBano(){
        contadorBaño++;
        contadorBaños.setText(contadorBaño + "");
    }
    private void minusCounterBano(){
        contadorBaño--;
        contadorBaños.setText(contadorBaño +"");
    }

}