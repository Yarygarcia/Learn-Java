package com.example.obspringdatajpa;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext app =  SpringApplication.run(ObSpringdatajpaApplication.class, args);

		PersonaReposirory reposirory = app.getBean(PersonaReposirory.class);
		Persona persona = new Persona(9, "lorena", 21);
		reposirory.save(persona);
		reposirory.findAll().forEach(n-> System.out.println(n.getId()));
		System.out.println(reposirory.count());


	}

}
