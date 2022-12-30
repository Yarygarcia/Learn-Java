package org.propiedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedades {

    public Properties cargarDatos() throws IOException {
        Properties propiedades = new Properties(); //Cremos el archivo properties
        InputStream archivo = new FileInputStream("C:\\Users\\Administrador\\IdeaProjects\\proyectoPDF\\src\\main\\resources\\conexion.properties"); //
        propiedades.load(archivo);
        return propiedades;
    }
}
