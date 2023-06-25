package com.example.myapplication.adaptadores;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entidades.Tarjeta;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewTarjetas extends RecyclerView.Adapter<RecycleViewTarjetas.ViewHolder> {

    ArrayList<Tarjeta> model;

    public RecycleViewTarjetas(ArrayList<Tarjeta> model) {
        this.model = model;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_tarjetas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tarjeta.setText(model.get(position).getTarjeta());
        holder.descripcion.setText(model.get(position).getDescripcion());
        holder.imagen.setImageResource(model.get(position).getTarjetaid());
    }

    @Override
    public int getItemCount() {

        if(model ==null){
            return 0;
        }else {
            return model.size();

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imagen;
        TextView tarjeta,descripcion;
        public RelativeLayout viewF,viewB;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imageTarjeta);
            tarjeta = itemView.findViewById(R.id.txtTarjeta);
            descripcion = itemView.findViewById(R.id.txtDescrpcion);
            viewF = itemView.findViewById(R.id.rl);
            viewB = itemView.findViewById(R.id.viewBackground);

        }
    }

    public void removeItem(int position){
        model.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Tarjeta item, int position){
        model.add(position,item);
        notifyItemInserted(position);
    }
}