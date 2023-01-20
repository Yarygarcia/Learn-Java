package org.example.spring;

import org.example.beans.Barcelona;
import org.example.beans.Jugador;
import org.example.beans.Juventus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");

        Jugador jug = (Jugador) app.getBean("jugador");

        int selectEquipo;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Seleccione un equipo\n1. Barcalona\n2. Juventus: ");
        selectEquipo = entrada.nextInt();
        switch (selectEquipo){
            case 1:
                jug.setEquipo(new Barcelona());
                break;
            case 2:
                jug.setEquipo(new Juventus());
                break;
        }

        System.out.println("Id: " + jug.getId() + "\nNombre: " + jug.getNombre() + "\nEquipo:  " + jug.getEquipo().mostrarEquipo() + "\nCamiseta:\n    Numero:" + jug.getCamiseta().getNumero()+ "\n    Marca:" + jug.getCamiseta().getMarca().getNombre());
    }
}