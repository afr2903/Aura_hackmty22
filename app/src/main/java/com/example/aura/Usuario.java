package com.example.aura;

import android.util.Pair;

public class Usuario {
    String nombre;
    String genero;
    int pin;
    String objetivo;
    Pair<String, String> contactosConfianza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Pair<String, String> getContactosConfianza() {
        return contactosConfianza;
    }

    public void setContactosConfianza(Pair<String, String> contactosConfianza) {
        this.contactosConfianza = contactosConfianza;
    }
}
