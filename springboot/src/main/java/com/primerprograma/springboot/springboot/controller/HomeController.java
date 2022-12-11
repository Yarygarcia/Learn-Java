package com.primerprograma.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import javax.annotation.Resource;

@Controller
public class HomeController {
    @RequestMapping("/")
    public @ResponseBody String inicio(){
        return "Bienvenido, estamos en el inicio de la página";
    }
}
