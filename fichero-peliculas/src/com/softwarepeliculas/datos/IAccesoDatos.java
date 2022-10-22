package com.softwarepeliculas.datos;

import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;
import com.softwarepeliculas.excepciones.EscrituraDatosExcepcion;
import com.softwarepeliculas.excepciones.LecturaDatosExcepcion;

import java.util.List;

public interface IAccesoDatos {

    public boolean comprobarExisteArchivo(String nombreRecurso) throws AccesoDatosExcepcion;
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepcion;
    public  void escribir(Pelicula pelicula, String nombreRecurso, boolean guardar) throws EscrituraDatosExcepcion;
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepcion;
    public void crear(String nombreRecurso) throws AccesoDatosExcepcion;
    public void borrar(String nombreRecurso) throws AccesoDatosExcepcion;
}
