package com.example.aura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;

public class RedPsicologos extends AppCompatActivity {

    RecyclerView listaPsics;
    ArrayList<Psicologo> psicologos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_psicologos);

        int[] imagenes = new int[]{R.drawable.psic1, R.drawable.psic4, R.drawable.psic5, R.drawable.psic2, R.drawable.psic3};
        String[] nombres = getResources().getStringArray(R.array.nombres);
        String[] numEstrellas = getResources().getStringArray(R.array.numEstrellas);
        String[] infos = getResources().getStringArray(R.array.info);

        psicologos = new ArrayList<Psicologo>();

        for(int i = 0; i<nombres.length; i++){
            Psicologo p = new Psicologo();
            p.setNombre(nombres[i]);
            p.setNumEstrellas(numEstrellas[i]);
            p.setInfo(infos[i]);
            p.setImagen(imagenes[i]);
            psicologos.add(p);
        }

        listaPsics = (RecyclerView) findViewById(R.id.rvPsic);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        inicializarAdaptador();
        listaPsics.setLayoutManager(llm);


    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(psicologos, this);
        listaPsics.setAdapter(adaptador);
    }
}