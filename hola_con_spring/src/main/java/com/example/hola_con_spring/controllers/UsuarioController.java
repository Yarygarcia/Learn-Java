package com.example.hola_con_spring.controllers;

import com.example.hola_con_spring.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value="usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Ana");
        usuario.setApellido("Cardona Henao");
        usuario.setTelefono(32314513);
        usuario.setEmail("anac1@gmail.com");
        usuario.setPassword("1234");
        return usuario;
    }
    @RequestMapping(value="usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setNombre("Ana");
        usuario1.setApellido("Cardona Henao");
        usuario1.setTelefono(32314513);
        usuario1.setEmail("anac1@gmail.com");
        usuario1.setPassword("1234");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("Juan");
        usuario2.setApellido("Lopez Franco");
        usuario2.setTelefono(53124);
        usuario2.setEmail("juan@gmail.com");
        usuario2.setPassword("124..");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setNombre("Karen");
        usuario3.setApellido("Roman Jimenez");
        usuario3.setTelefono(214513);
        usuario3.setEmail("karenr@gmail.com");
        usuario3.setPassword("6541_4");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }

    public void modificar(){

    }

    public void eliminar(){

    }

    public void agregar(){

    }

    public void buscar(){

    }


}
