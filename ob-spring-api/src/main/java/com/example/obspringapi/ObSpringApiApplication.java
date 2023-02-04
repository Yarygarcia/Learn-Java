package com.example.obspringapi;

import com.example.obspringapi.entities.Libro;
import com.example.obspringapi.repositories.LibroRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObSpringApiApplication {

	public static void main(String[] args) {

		ApplicationContext app =  SpringApplication.run(ObSpringApiApplication.class, args);
		Libro libro1 = new Libro(null, "El principito", "NN", 30, 2000.0, LocalDate.of(2001,12,02), true);
		Libro libro2 = new Libro(null, "Homo", "N.N", 110, 36000.0, LocalDate.of(1991,05,21), true);
		LibroRepository repositori = app.getBean(LibroRepository.class);

		repositori.save(libro1);
		repositori.save(libro2);
	}


}


