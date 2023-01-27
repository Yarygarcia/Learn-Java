package com.example.obspringdatajpa;

import org.springframework.data.repository.CrudRepository;

public interface PersonaReposirory extends CrudRepository<Persona, Long> {

    Persona findByNombre(String nombre);
    Persona save(Persona persona);
}
