package interfaces;

import dao.Conector;
import personas.Empleado;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoImplementacion implements IEmpleado{
    private Connection conexion;
    Conector conector = Conector.getInstance();

    public EmpleadoImplementacion() throws SQLException {
    }


    @Override
    public void regitrar(Empleado empleado) {
        try{
            conexion = conector.conectar();
            PreparedStatement registrar = conexion.prepareStatement("INSERT INTO empleados VALUES(?,?,?) ");

            registrar.setInt(1, 0);
            registrar.setString(2, empleado.getNombre());
            registrar.setString(3, empleado.getCargo());
            registrar.executeUpdate();

            conector.desconectar();
        }catch (Exception exception){
            System.out.println("Error al registrar usuario" + exception.getMessage());
        }
    }

    @Override
    public void Verificar() {
        try{
            conexion = conector.conectar();
            PreparedStatement verificar = conexion.prepareStatement("SELECT * FROM empleados");
            ResultSet consulta = verificar.executeQuery();
            if(consulta.next()){
                JOptionPane.showMessageDialog(null , "Sí hay datos en la BD");
            }else{
                JOptionPane.showMessageDialog(null, "No hay datos en la BD");
            }
            conector.desconectar();
        }catch (SQLException exception){
            System.out.println("Error de verificación " + exception.getMessage());
        }
    }


    @Override
    public void modificar(Empleado empleado, int id) {
        try{
            conexion = conector.conectar();
            int idEmpleado = id;
            PreparedStatement modificar = conexion.prepareStatement("UPDATE  empleados SET nombres = ?, cargo = ?   WHERE id =" + idEmpleado);
            modificar.setString(1, empleado.getNombre());
            modificar.setString(2, empleado.getCargo());
            modificar.executeUpdate();
            conector.desconectar();
        }catch (SQLException exception){
            System.out.println("Error al modificar " + exception.getMessage());
        }
    }

    @Override
    public void buscar(Empleado empleado) {
        try{
            conexion = conector.conectar();
            PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM empleados WHERE id=?" );
            buscar.setInt(1, empleado.getId());
            ResultSet consultar = buscar.executeQuery();
            while(consultar.next()){
                empleado.setNombre(consultar.getString("nombres"));
                empleado.setCargo(consultar.getString("cargo"));
            }

            conector.desconectar();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void eliminar(Empleado empleado, int idE) {
        try {
            conector.conectar();
//            conexion = conector.conectar();
//            PreparedStatement eliminar = conexion.prepareStatement("DELETE FROM empleados WHERE id=?");
//            eliminar.setInt(1, idE);
//            eliminar.executeUpdate();
            conector.desconectar();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
