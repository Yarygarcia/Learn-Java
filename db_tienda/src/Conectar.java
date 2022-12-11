import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    static Conectar conect;
    static Connection conexion;
    static private String url = "jdbc:mysql://localhost:3306/db_tienda";
    static private String user = "root";
    static private String pws = "";

    public Conectar(){

    }

    public static Connection getInstance() throws SQLException {
        if(conect == null){
            conect = new Conectar();
            conect.conectar();
            conect.desconectar();
        }
        return conexion;
    }

    public  Connection conectar(){
        try{
            conexion = DriverManager.getConnection(url, user, pws);
            System.out.println("Base de datos conectada");
        }catch (SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
        return conexion;
    }

    public Connection desconectar() throws SQLException {
        try{
            conexion.close();
            System.out.println("Base de datos desconectada");
        }catch (SQLException ex){
            throw  new RuntimeException(ex.getMessage());
        }finally {
            conexion.close();
        }
        return conexion;
    }
}
