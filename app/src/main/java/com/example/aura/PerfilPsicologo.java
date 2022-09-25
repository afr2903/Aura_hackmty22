package com.example.aura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PerfilPsicologo extends AppCompatActivity {

    RecyclerView listaPsics;
    ArrayList<Psicologo> psicologos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_psicologo);

        listaPsics = (RecyclerView) findViewById(R.id.rvPsic);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        inicializarAdaptador();
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPsics.setLayoutManager(llm);
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(psicologos, this);
        listaPsics.setAdapter(adaptador);
    }


}