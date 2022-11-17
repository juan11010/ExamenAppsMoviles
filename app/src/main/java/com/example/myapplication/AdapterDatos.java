package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {
    ArrayList<ModeloArticulo> lista;

    public AdapterDatos(ArrayList<ModeloArticulo> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, int position) {
        holder.id.setText(lista.get(position).getId());
        holder.nombre.setText(lista.get(position).getName());
        holder.precio.setText(lista.get(position).getPrice());
        holder.tipo.setText(lista.get(position).getType());
        holder.des.setText(lista.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView id;
        TextView nombre;
        TextView precio;
        TextView tipo;
        TextView des;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView10);
            nombre = itemView.findViewById(R.id.textView6);
            precio = itemView.findViewById(R.id.textView7);
            tipo = itemView.findViewById(R.id.textView8);
            des = itemView.findViewById(R.id.textView9);
        }
    }
}
