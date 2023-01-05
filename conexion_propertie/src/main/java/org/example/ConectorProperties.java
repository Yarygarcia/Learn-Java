package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConectorProperties {

    public Properties getFile() throws IOException {
        Properties properties = new Properties();
        InputStream archivo = new FileInputStream("C:\\Users\\Administrador\\IdeaProjects\\conexion_propertie\\src\\main\\resources\\conexion.properties");
        properties.load(archivo);
        return properties;
    }
}