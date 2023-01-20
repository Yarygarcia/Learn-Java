package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Jugador {
    private String  nombre;
    private int numero;
    private IEquipo equipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public IEquipo getEquipo() {
        return equipo;
    }
    public void setEquipo(IEquipo equipo) {
        this.equipo = equipo;
    }
}
