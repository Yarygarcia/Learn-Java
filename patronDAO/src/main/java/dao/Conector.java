package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    private static Conector conector = null;
    private  final String  URL ="jdbc:mysql://localhost:3306/db_empleado";
    private final String USER = "root";
    private final String PSW = "";
    private Connection conexion;

    public Conector(){

    }

    public static Conector getInstance() throws SQLException {
        if(conector == null){
            conector = new Conector();
        }
        return conector;
    }



    public Connection conectar() throws SQLException {
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_empleado", "root", "");
            System.out.println("BD conectada con exito !!!");
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        }
            return  conexion;
    }

    public void desconectar() throws SQLException {
        try{
            conexion.close();
            System.out.println("DB desconectada con exito !!!");
        }catch (SQLException exception){
            System.out.println("Error al desconectar " + exception.getMessage());
            conexion.close();
        }finally {
            conexion.close();
        }

    }


}

