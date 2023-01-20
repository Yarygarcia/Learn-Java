package com.example.spring;

import com.example.beans.Barcelona;
import com.example.beans.IEquipo;
import com.example.beans.Jugador;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");

        Jugador jugador1 = (Jugador) app.getBean("jugador");
        IEquipo equipo = (IEquipo) app.getBean("realMadrid");

        System.out.println(jugador1.getNombre() + " " + jugador1.getNumero() + " " + equipo.mostrarEquipo());
    }
}
