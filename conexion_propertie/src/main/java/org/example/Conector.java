package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public  class Conector {

    static Conector conector = null;
    Connection conexion;

    public static Conector getInstance(){
        if(conector == null){
           conector = new Conector();
        }
        return conector;
    }

    public Connection conectar() throws SQLException {
        try{
            ConectorProperties conectorProperties = new ConectorProperties();
            Properties properties = conectorProperties.getFile();

            String url = properties.getProperty("conector.url");
            String user = properties.getProperty("conector.user");
            String psw = properties.getProperty("conector.password");
            conexion = DriverManager.getConnection(url, user, psw);
            if(conexion != null){
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Error al conectar la BD");
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            conexion.close();
            System.out.println("Desconexion exitosa");
        }
        return conexion;
    }
}