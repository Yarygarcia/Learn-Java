package com.example.spring;

import com.example.beans.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Usuario.class);

        Usuario usuario =(Usuario) app.getBean("usuario");
        System.out.println(usuario.saludar());
    }
}
