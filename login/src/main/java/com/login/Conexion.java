package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion;

    static Conexion conector;

    public static Conexion getInstance(){
        if(conector == null){
            conector = new Conexion();
        }
        return conector;
    }

    public Connection conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_usuarios", "root", "");
            System.out.println("Conexion exitosa!!");
        }catch ( SQLException exception){
            System.out.println(exception.getMessage());
        }
        return conexion;
    }

    public void desconectar() throws SQLException {
        try{
            conexion.close();
            System.out.println("Desconexiòn exitosa");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            conexion.close();
        }
    }
}
