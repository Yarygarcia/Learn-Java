package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Jugador {
    @Value("1")
    private int id;
    @Value("Katalina")
    private String nombre;
    @Autowired
    private IEquipo equipo;
    @Autowired
    private Camiseta camiseta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public IEquipo getEquipo() {
        return equipo;
    }

    public void setEquipo(IEquipo equipo) {
        this.equipo = equipo;
    }

    public Camiseta getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(Camiseta camiseta) {
        this.camiseta = camiseta;
    }
}
