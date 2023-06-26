package com.example.myapplication.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Imagenes;
import com.example.myapplication.R;

import java.util.List;

public class RecycleViewImagen extends RecyclerView.Adapter<RecycleViewImagen.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo,fecha,hora;
        ImageView foto;


    public ViewHolder(View itemView){
        super(itemView);
        titulo = (TextView) itemView.findViewById(R.id.textView3);
        fecha = (TextView) itemView.findViewById(R.id.textView4);
        hora = (TextView) itemView.findViewById(R.id.textView5);
        foto =  (ImageView) itemView.findViewById(R.id.imageViewimagen);
        }

    }

    public List<Imagenes> imagenesLista;

    public RecycleViewImagen(List<Imagenes> imagenesLista){
        this.imagenesLista = imagenesLista;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicios,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titulo.setText(imagenesLista.get(position).getTitulo());
        holder.fecha.setText(imagenesLista.get(position).getFecha());
        holder.hora.setText(imagenesLista.get(position).getHora());
        holder.foto.setImageResource(imagenesLista.get(position).getImagen());
    }

    @Override
    public int getItemCount() {

        return imagenesLista.size();
    }
}
