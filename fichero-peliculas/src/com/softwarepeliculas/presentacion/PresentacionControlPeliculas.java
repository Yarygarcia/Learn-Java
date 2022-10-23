package com.softwarepeliculas.presentacion;

import com.softwarepeliculas.servicio.ControlPeliculasImpl;
import com.softwarepeliculas.servicio.IControlPeliculas;

import java.util.Scanner;

public class PresentacionControlPeliculas {
    public static void main(String[] args) {
        IControlPeliculas control = new ControlPeliculasImpl();
        Scanner entrada = new Scanner(System.in);
        int opcion;
        System.out.println("--------------------------------------");
        System.out.println("Software - Control de peliculas");
        System.out.println("--------------------------------------");
        do {
            System.out.println("Ingre la opción deseada");
            System.out.println("1. Iniciar control de peliculas");
            System.out.println("2. Agregar pelicula");
            System.out.println("3. Buscar pelicula");
            System.out.println("4. Listar peliculas");
            System.out.println("5. salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1: control.iniciarControlPelicula();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.print("Ingresa el nombre de la pelicula  a agregar: ");
                    String nombrePeliculaAAgregar = entrada.nextLine();
                    control.agregarPelicula(nombrePeliculaAAgregar);
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println();
                    System.out.print("Ingrese el nombre de la pelicula a buscar: ");
                    String nombrePeliculaABuscar = entrada.nextLine();
                    control.buscarPelicula(nombrePeliculaABuscar);
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.println("       Peliculas       ");
                    System.out.println("----------------------");
                    control.listarPelicula();
                    break;
                case 5:
                    System.out.println("------------------");
                    System.out.println("Hasta pronto");
                    System.out.println("------------------");
                    opcion= 5;
                    break;
                default:
                    System.out.println("-----------------");
                    System.out.println("Opción invalida, vuelve a intentar");
                    System.out.println("-----------------");
            }

        }while (opcion != 5);
    }
}
