package com.softwarepeliculas.servicio;

import com.softwarepeliculas.datos.AccesoDatosImpl;
import com.softwarepeliculas.datos.IAccesoDatos;
import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;
import com.softwarepeliculas.excepciones.LecturaDatosExcepcion;

import java.util.List;

public class ControlPeliculasImpl implements IControlPeliculas{
    private final IAccesoDatos datos;
    public ControlPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar= false;
        try{
            anexar = datos.comprobarExisteArchivo(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO,anexar);
        }catch (AccesoDatosExcepcion e){
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPelicula() {
        try{
            List<Pelicula> peliculas =  this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas){
                System.out.println("Pelicula: " +pelicula);
            }
        }catch (AccesoDatosExcepcion e){
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreABuscarPelicula) {
        String resultado = null;
        try{
            resultado = this.datos.buscar(NOMBRE_RECURSO, nombreABuscarPelicula);

        }catch (AccesoDatosExcepcion e){
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
        if (resultado == null){
            System.out.println("Pelicula " + nombreABuscarPelicula + " No encontrada");
        }else{
            System.out.println("Pelicula "+ resultado + " encontrada");
        }

    }

    @Override
    public void iniciarControlPelicula() {
        //Elimina y crea el archivo de nuevo
        try{
            if(this.datos.comprobarExisteArchivo(NOMBRE_RECURSO)){
                this.datos.borrar(NOMBRE_RECURSO);
                this.datos.crear(NOMBRE_RECURSO);
            }else{
                this.datos.crear(NOMBRE_RECURSO);
            }
        }catch (AccesoDatosExcepcion e){
            System.out.println("Error al iniciar control de peliculas");
            e.printStackTrace(System.out);
        }
    }
}
