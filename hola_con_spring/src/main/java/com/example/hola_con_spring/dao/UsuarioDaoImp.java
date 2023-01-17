package com.example.hola_con_spring.dao;

import com.example.hola_con_spring.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    //Realizar la conexiòn con la base de datos
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuario() {

        String query = "";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        return lista;

    }
}