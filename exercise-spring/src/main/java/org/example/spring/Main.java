package org.example.spring;

import org.example.beans.Barcelona;
import org.example.beans.IEquipo;
import org.example.beans.Jugador;
import org.example.beans.Juventus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numEquipo;
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");

        Jugador jugador = (Jugador) app.getBean("jugador");

        System.out.println("Selecciona un equipo\n1. Barcelona\n2.Juventus");
        numEquipo = sc.nextInt();

        switch (numEquipo){
            case 1:
                jugador.setEquipo(new Barcelona());
                break;
            case 2:
                jugador.setEquipo(new Juventus());
                break;
        }

        System.out.println("Id: "+ jugador.getId() + "\nNombre: " + jugador.getNombre() + "\nEquipo: " + jugador.getEquipo().mostrarEquipo() + "\nCamiseta: \n   Id: " + jugador.getCamiseta().getId() + "\n   Numero: " + jugador.getCamiseta().getNumero() + "\n   Marca: " + jugador.getCamiseta().getMarca().getNombre());



    }

}