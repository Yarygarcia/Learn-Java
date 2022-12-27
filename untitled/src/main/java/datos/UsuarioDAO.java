package datos;

import domain.Usuario;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    private final String  SQL_SELECT ="SELECT * FROM usuarios";
    private final String SQL_ELIMINAR = "DELETE FROM usuarios WHERE id =?";
    private final String SQL_CREAR = "INSERT INTO usuarios(user, psw) VALUES(?,?)";
    private  final String SQL_ACTUALIZAR = "UPDATE usuarios SET user=?, psw=? WHERE id=?";

    private final String SQL_BUSCAR = "SELECT * FROM usuarios WHERE id =?";

    private Connection conexion;
    private Conexion conector = Conexion.getInstance();
    ArrayList<Usuario> usuarios = new ArrayList<>();


    public ArrayList<Usuario> listar(){
        PreparedStatement listar;
        ResultSet consula;

        try{
            conexion = conector.conectar();
            listar = conexion.prepareStatement(SQL_SELECT);
            consula = listar.executeQuery();
            Usuario usuario;
            usuarios.clear();
            while (consula.next()){
                int id = consula.getInt(1);
                String user = consula.getString(2);
                String password = consula.getString(3);
                usuario = new Usuario(id, user,password);
                usuarios.add(usuario);
            }
            conector.desconectar();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return usuarios;
    }

    public void eliminar(Usuario usuario){
        PreparedStatement eliminar;
        ResultSet consulta;

        try{
            conexion = conector.conectar();
            eliminar = conexion.prepareStatement(SQL_ELIMINAR);
            eliminar.setInt(1, usuario.getId());
            eliminar.executeUpdate();
            conector.desconectar();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
    public void crear(Usuario usuario){
        PreparedStatement crear;
        try{
            conexion = conector.conectar();
            crear = conexion.prepareStatement(SQL_CREAR);
            crear.setString(1, usuario.getUser());
            crear.setString(2,usuario.getPassword());
            crear.executeUpdate();
            conector.desconectar();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void actualizar(Usuario usuario){
        PreparedStatement actualizar;
        try{
            conexion = conector.conectar();
            actualizar= conexion.prepareStatement(SQL_ACTUALIZAR);
            actualizar.setString(1, usuario.getUser());
            actualizar.setString(2, usuario.getPassword());
            actualizar.setInt(3, usuario.getId());
            actualizar.executeUpdate();
            conector.desconectar();
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void buscar(Usuario usuario){
        PreparedStatement buscar;
        ResultSet consulta;
        try{
            conexion = conector.conectar();
            buscar = conexion.prepareStatement(SQL_BUSCAR);
            buscar.setInt(1, usuario.getId());
            consulta = buscar.executeQuery();
            if(consulta.next()){
                usuario.setId(consulta.getInt(1));
                usuario.setUser(consulta.getString(2));
                usuario.setPassword(consulta.getString(3));
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no existe");
            }
            conector.desconectar();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
}
