package com.example.aura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfilPsicologo extends AppCompatActivity {

    TextView tvNombre;
    TextView tvEstrellas;
    ImageView imgFoto;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_psicologo);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String estrellas = extras.getString("estrellas");
        int imagen = extras.getInt("imagen");
        String info = extras.getString("info");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEstrellas = (TextView) findViewById(R.id.tvEstrellas);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        tvNombre.setText(nombre);
        tvEstrellas.setText("Calificación: " + estrellas);
        tvInfo.setText(info);
        imgFoto.setImageResource(imagen);


    }

    public void inicializarAdaptador(){

    }


}