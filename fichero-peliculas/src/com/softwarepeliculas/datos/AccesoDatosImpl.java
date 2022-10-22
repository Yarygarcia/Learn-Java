package com.softwarepeliculas.datos;

import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;
import com.softwarepeliculas.excepciones.EscrituraDatosExcepcion;
import com.softwarepeliculas.excepciones.LecturaDatosExcepcion;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

//Implementamos los mètodos de La Interfaz IAccesoDatos
public class AccesoDatosImpl  implements  IAccesoDatos{

    @Override
    public boolean comprobarExisteArchivo(String nombreRecurso) throws AccesoDatosExcepcion {
        File archivo = new File(nombreRecurso);
        //Sí el archivo existe, retornará true
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepcion {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new LinkedList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String contenido = null;
            contenido = lector.readLine();
            while (contenido != null){
                peliculas.add(new Pelicula(contenido));
                contenido = lector.readLine();
            }
            lector.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepción al listar peliculas" + e.getMessage());
        }
        return  peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean guardar) throws EscrituraDatosExcepcion {
        File archivo = new File(nombreRecurso);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, guardar));
            salida.print(pelicula.toString());
            salida.close();
            System.out.println();
            System.out.println("Se a añadido la pelicula: " + pelicula);

        }catch (IOException e){
            e.printStackTrace(System.out);
            throw  new EscrituraDatosExcepcion("Excepción al escribir en el archivo" + e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscarNombrePelicula) throws LecturaDatosExcepcion {
        File archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = lector.readLine();
            int contador =1;
            while (linea!= null){
                if(buscarNombrePelicula != null && buscarNombrePelicula.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + buscarNombrePelicula + "encontrada";

                    break;
                }else {
                    resultado = "Pelicula " + buscarNombrePelicula + "NO encontrada";
                }
                linea = lector.readLine();
                contador++;
            }
            lector.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepción al buscar pelicula: "+ e.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcepcion {
        File archivo = new File(nombreRecurso);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepcion("Excepción de acceso de datos" + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosExcepcion {
        File archivo = new File(nombreRecurso);
        try{
            if (archivo.exists()){
                archivo.delete();
                System.out.println("Archivo eliminado correctamente");
            }else{
                System.out.println("Archivo no encontrado");
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
