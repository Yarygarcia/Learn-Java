package org.example.beans;

import org.springframework.stereotype.Component;

//@Component
public class Juventus  implements  IEquipo{
    @Override
    public String mostrarEquipo() {
        return "Juventus";
    }
}
