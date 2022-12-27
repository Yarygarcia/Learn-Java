package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String URL ="jdbc:mysql://localhost:3306/db_usuarios";
    private final String USER = "root";
    private final String PSW = "";
    Connection conexion;
    static Conexion instancia;

    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return  instancia;
    }

    public Connection conectar(){
        try{
            conexion = DriverManager.getConnection(URL, USER, PSW);
            System.out.println("Conexión exitosa");
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return conexion;
    }

    public void desconectar() throws SQLException {
        try{
            conexion.close();
            System.out.println("Desconectado exitosamente");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            conexion.close();
        }finally {
            conexion.close();
        }
    }
}
