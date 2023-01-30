package com.example.obspringapi.controllers;

import com.example.obspringapi.entities.Libro;
import com.example.obspringapi.repositories.LibroRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibroController {

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
    @PostMapping("api/libros")
    public void crear(@RequestBody Libro libro, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        repository.save(libro);
    }

}
