package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.myapplication.adaptadores.RecycleViewImagen;

import java.util.ArrayList;
import java.util.List;

public class HistorialFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private RecycleViewImagen adaptadorImagen;


    public HistorialFragment() {
    }

    public static HistorialFragment newInstance(String param1, String param2) {
        HistorialFragment fragment = new HistorialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historial, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleImagen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adaptadorImagen = new RecycleViewImagen(obtenerImagenes());
        recyclerView.setAdapter(adaptadorImagen);

        return view;

    }

    public List<Imagenes> obtenerImagenes(){
        List<Imagenes> imagenes = new ArrayList<>();
        imagenes.add(new Imagenes("Servicio de Limpieza","Hora: 5:30pm","Fecha: 03/02/16",R.drawable.limpieza));
        imagenes.add(new Imagenes("Servicio eléctrico","Hora: 6:30pm","Fecha: 05/02/16",R.drawable.electricista));
        imagenes.add(new Imagenes("Servicio de gasfitero","Hora: 7:30pm","Fecha: 07/02/16",R.drawable.gasfitero));
        return imagenes;
    }
}