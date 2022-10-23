package com.softwarepeliculas.servicio;

public interface IControlPeliculas {
    final String NOMBRE_RECURSO = "peliculas.txt";
    public void agregarPelicula(String nombrePelicula);
    public void listarPelicula();

    public void buscarPelicula(String nombreABuscarPelicula);

    public  void iniciarControlPelicula();

}
