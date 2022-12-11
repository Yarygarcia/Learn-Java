package com.primerprograma.springboot.springboot.controller;

import com.primerprograma.springboot.springboot.service.SaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SaludoController {
    @Autowired
    private SaludoService service;
    @RequestMapping("/saludo/{nombre}")
    public @ResponseBody String saludo(@PathVariable(value="nombre") String nombre){
        return service.saludar(nombre);
    }
}
