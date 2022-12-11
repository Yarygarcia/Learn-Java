import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private Connection conexion;
    static Conector con;


    public Conector(){

    }

    public static Conector getInstance() throws SQLException {
        con = new Conector();
        con.conectar();
        con.desconectar();
       return con;
    }

    public Connection conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_trabajo", "root", "");
            System.out.println("Base de datos CONECTADA!!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conexion;

    }
    public  Connection desconectar() throws SQLException {
        try{
            conexion.close();
            System.out.println("Base de datos DESCONECTADA!!");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            conexion.close();
        }finally {
            conexion.close();
        }
        return conexion;
    }
}
