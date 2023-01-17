package com.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppUser {
    @Bean
    public Usuario usuario(){
        return  new Usuario();
    }
}
