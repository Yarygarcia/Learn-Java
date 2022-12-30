package org.example;

import org.propiedades.Propiedades;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conector {
    static Conector conector;
    Connection conexion;
    Propiedades propiedades = new Propiedades();

    public static Conector getInstance(){

        if(conector == null){
            conector = new Conector();
        }
        return conector;
    }

    public Connection conectar(){
        try{
            Properties propertie = propiedades.cargarDatos();
            String user = propertie.getProperty("conexion.user");
            String url = propertie.getProperty("conexion.url");
            String psw = propertie.getProperty("conexion.password");
            conexion = DriverManager.getConnection(url, user, psw);
            if(conexion != null){
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("ERROR AL CONECTAR");
            }
        }catch (SQLException exception){
            System.out.println("ERROR: " + exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conexion;
    }

    public void desconectar() throws SQLException {
        try{
            conexion.close();
            System.out.println("Desconexión exitosa");
        }catch (SQLException exception){
            System.out.println("Error: " + exception.getMessage());
            conexion.close();
        }
    }
}
