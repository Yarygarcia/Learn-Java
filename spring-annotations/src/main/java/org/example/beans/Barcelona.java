package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Barcelona implements IEquipo{
    @Override
    public String mostrarEquipo() {
        return "Barcelona";
    }
}
