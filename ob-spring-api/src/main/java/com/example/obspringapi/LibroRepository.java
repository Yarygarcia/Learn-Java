package com.example.obspringapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {

    Libro save(Libro libro);

    Libro findById(long id);

    String deleteLibrosById(long id);

    Libro getAll();

    Libro getById(long id);
}
