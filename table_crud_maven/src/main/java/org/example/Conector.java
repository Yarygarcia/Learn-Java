package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    Connection conexion;

    static Conector conector = null;

    public static Conector getInstance(){
        if(conector == null){
            conector = new Conector();
        }
        return conector;
    }

    public Connection conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_empleado", "root", "");
            System.out.println("Conexion exitosa");
        }catch (SQLException e){
            System.out.println("Error" +e);
        }
        return  conexion;
    }

    public void desconectar(){
        try{
            conexion.close();
            System.out.println("Desconexion exitosa");
        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }


}
