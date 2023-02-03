package com.example.obspringapi.controllers;

import com.example.obspringapi.entities.Libro;
import com.example.obspringapi.repositories.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibroController {
    private final Logger log = LoggerFactory.getLogger(LibroController.class);
    private final LibroRepository repository;

    public LibroController(LibroRepository repository){
        this.repository = repository;
    }


    @GetMapping("/api/libros")
    public List<Libro> findAll(){
        return repository.findAll();
    }

    @GetMapping("/api/libros/{id}")
    public ResponseEntity<Libro> finById(@PathVariable Long id){
        Optional<Libro> libro = repository.findById(id);

        //Forma num 1
//        if(libro.isPresent()){
//            return ResponseEntity.ok(libro.get)
//        }else{
//            return ResponseEntity.notFound().build();
//        }

        //Forma num 2
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @PostMapping("/api/libros")
    public ResponseEntity<Libro> crear(@RequestBody Libro libro, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(libro.getId() != null){
            log.warn("Intentando crear un libro con id");
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(repository.save(libro));
        }
    }

    @PutMapping("/api/libros/{id}")
    public ResponseEntity<Libro> actualizaribro(@RequestBody Libro libro){
        if(libro.getId() == null){
            log.warn("Actualizar un libro por medio del id");
            return ResponseEntity.notFound().build();
        }
        if(!repository.existsById(libro.getId())){
            log.warn("Actualizar - no existe libro");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repository.save(libro));
    }

    @DeleteMapping("/api/libros/{id}")
    public ResponseEntity<Libro> eliminarLibro(@PathVariable Long id){
        if(!repository.existsById(id)){
            log.warn("Internat eliminar libro por id");
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/libros")
    public ResponseEntity<Libro> eliminarTodo(){
        if(repository.count() == 0){
            log.warn("Eliminando todos los registros");
            return ResponseEntity.noContent().build();
        }
        repository.deleteAll();
        return ResponseEntity.noContent().build();

    }


}
