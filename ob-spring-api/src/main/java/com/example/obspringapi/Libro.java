package com.example.obspringapi;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="db-libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    @Column(name="num_paginas")
    private Integer numPaginas;
    private Double precio;
    @Column(name="fecha_publicacion")
    private LocalDate fechaPublicacion;
    private double online;

    public Libro(){

    }

    public Libro(Long id, String titulo, String autor, Integer numPaginas, Double precio, LocalDate fechaPublicacion, double online) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return titulo;
    }

    public void setTitle(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getOnline() {
        return online;
    }

    public void setOnline(double online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", title='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPaginas=" + numPaginas +
                ", precio=" + precio +
                ", fechaPublicacion=" + fechaPublicacion +
                ", online=" + online +
                '}';
    }
}
