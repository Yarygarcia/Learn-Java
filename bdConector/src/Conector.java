import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    static Conector conector;
    static Connection conexion;
    public Conector(){

    }

    public  Connection conectar(){
            try{
                conector = new Conector();
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_registros", "root", "");
                System.out.println("Conexion exitosa!!");
            }catch (SQLException e){
                throw  new RuntimeException(e.getMessage());
            }

        return conexion;
    }

    public  Connection desconectar() throws SQLException {
        try {
            conexion.close();
            System.out.println("Conexion cerrada");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            conexion.close();
        }finally {
            conexion.close();
        }
        return conexion;
    }

}
