package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class EditarDireccion extends AppCompatActivity  {

    ArrayList<Direccion> direcciones;
    RecyclerView recycle;
    EditText direccion,distrito;
    AdaptadorPersona ap;
    Button siguiente;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_direccion);
        recycle = findViewById(R.id.recycle);
        direccion = findViewById(R.id.direccion);
        distrito = findViewById(R.id.distrito);
        direcciones = new ArrayList<Direccion>();
        LinearLayoutManager l=new LinearLayoutManager(this);
        recycle.setLayoutManager(l);
        ap=new AdaptadorPersona();
        recycle.setAdapter(ap);
        siguiente = findViewById(R.id.volverdireccion);
        siguiente.setOnClickListener(view -> {
            Toast.makeText(EditarDireccion.this, "", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(EditarDireccion.this,Servicio.class));
        });

    }

    public void agregar(View v)
    {
        Direccion persona1=new Direccion(direccion.getText().toString(),distrito.getText().toString());
        direcciones.add(persona1);
        direccion.setText("");
        distrito.setText("");
        recycle.scrollToPosition(direcciones.size()-1);
    }

    public void eliminar(View v)
    {
        int pos=-1;
        for(int f=0;f<direcciones.size();f++)
        {
            if(direcciones.get(f).getNombre().equals(direccion.getText().toString()))
                pos=f;
        }
        if (pos!=-1)
        {
            direcciones.remove(pos);
            direccion.setText("");
            distrito.setText("");
            ap.notifyDataSetChanged();
            Toast.makeText(this,"Se elimino la direccion",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"No existe la direccion",Toast.LENGTH_SHORT).show();
    }

    public void mostrar(int pos)
    {
        direccion.setText(direcciones.get(pos).getNombre());
        distrito.setText(direcciones.get(pos).getTelefono());
    }

    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return direcciones.size();
        }
        class AdaptadorPersonaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv1,tv2;
            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);
                tv1=itemView.findViewById(R.id.textDireccion);
                tv2=itemView.findViewById(R.id.textDistrito);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                tv1.setText("Direccion : "+direcciones.get(position).getNombre());
                tv2.setText("Distrito : "+direcciones.get(position).getTelefono());
            }

            @Override
            public void onClick(View v) {
                mostrar(getLayoutPosition());
            }
        }
    }
}
