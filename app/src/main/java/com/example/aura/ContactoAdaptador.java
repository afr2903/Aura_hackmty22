package com.example.aura;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ConctactoViewHolder> {

    ArrayList<Psicologo> psics;
    Activity activity;

    public int getItemCount() {
        return psics.size();
    }

    public ContactoAdaptador(ArrayList<Psicologo> psics, Activity activity){
        this.psics = psics;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ConctactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardpsicologo, parent, false);
        return new ConctactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdaptador.ConctactoViewHolder holder, int position) {
        Psicologo psicologo = psics.get(position);
        holder.imgFoto.setImageResource(psicologo.getImagen());
        holder.tvTituloTarjeta.setText(psicologo.getNombre());
        holder.tvEstrellas.setText(psicologo.getNumEstrellas());

        holder.eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PerfilPsicologo.class);
                intent.putExtra("nombre", psicologo.getNombre());
                intent.putExtra("estrellas", psicologo.getNumEstrellas());
                intent.putExtra("imagen", psicologo.getImagen());
                intent.putExtra("info", psicologo.getInfo());
                activity.startActivity(intent);
            }
        });
    }

    public static class ConctactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvTituloTarjeta;
        private TextView tvEstrellas;
        private ImageButton eyeIcon;

        public ConctactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvTituloTarjeta = (TextView) itemView.findViewById(R.id.tvTituloTarjeta);
            tvEstrellas = (TextView) itemView.findViewById(R.id.tvEstrellas);
            eyeIcon = (ImageButton) itemView.findViewById(R.id.eyeIcon);
        }

    }

}
