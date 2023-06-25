package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.adaptadores.RecycleViewTarjetas;
import com.example.myapplication.callbar.myItemTouchHelperCallback;
import com.example.myapplication.entidades.Tarjeta;
import com.example.myapplication.interfaces.CallBackItemTouch;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MetodosTarjeta extends AppCompatActivity implements CallBackItemTouch {


    RecyclerView recyclerView;
    RecycleViewTarjetas adapterrecycleViewTarjetas;
    ArrayList<Tarjeta> listaTarjetas;
    RelativeLayout layout;
    Button volver;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_tarjeta);
        recyclerView = findViewById(R.id.recycleview);
        volver = findViewById(R.id.volverinicio);
        volver.setOnClickListener(view -> {
            Toast.makeText(MetodosTarjeta.this, "", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MetodosTarjeta.this,Servicio.class));
        });

        layout = findViewById(R.id.layout_metodoTarjeta);
        listaTarjetas = new ArrayList<>();
        cargarLista();
        mostrarData();

    }
    public void cargarLista(){
        listaTarjetas.add(new Tarjeta("Interbank","405",R.drawable.tarjeta1));
        listaTarjetas.add(new Tarjeta("VISA","107",R.drawable.tarjeta2));
        listaTarjetas.add(new Tarjeta("Scotiabank","443",R.drawable.tarjeta3));
    }

    public void mostrarData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterrecycleViewTarjetas = new RecycleViewTarjetas(listaTarjetas);
        recyclerView.setAdapter(adapterrecycleViewTarjetas);
        ItemTouchHelper.Callback callback = new myItemTouchHelperCallback(this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void itemTouchOnMode(int oldPosition, int newPosition) {
        listaTarjetas.add(newPosition,listaTarjetas.remove(oldPosition));
        adapterrecycleViewTarjetas.notifyItemMoved(oldPosition,newPosition);

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int position) {
        String nombre  = listaTarjetas.get(viewHolder.getAdapterPosition()).getTarjeta();
        final Tarjeta deletedItem =listaTarjetas.get(viewHolder.getAdapterPosition());
        final int deletedIndex = viewHolder.getAdapterPosition();
        adapterrecycleViewTarjetas.removeItem(viewHolder.getAdapterPosition());
        Snackbar snackbar = Snackbar.make(layout,nombre +" -> Eliminado", Snackbar.LENGTH_LONG);
        snackbar.setAction("Deshacer", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterrecycleViewTarjetas.restoreItem(deletedItem,deletedIndex);
            }
        });
        snackbar.setActionTextColor(Color.GREEN);
        snackbar.show();

    }
}