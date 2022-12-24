package com.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tabla extends JFrame {

    private JPanel panel;
    private JTextField txtName;
    private JButton btnModificar;
    private JTextField txtBuscar;
    private JButton btnModificarBuscar;
    private JButton btnListar;
    private JButton btnLimpiar;
    private JButton btnBuscar;
    private JPasswordField txtPsw1;
    private JPasswordField txtPsw2;
    private JTextArea txtListar;
    Conexion conector = Conexion.getInstance();
    Connection conexion;

    public Tabla() {
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText("");
                try{
                    conexion = conector.conectar();
                    PreparedStatement listar = conexion.prepareStatement("SELECT * FROM usuarios");
                    ResultSet consulta = listar.executeQuery();
                    txtListar.append("Identificación");
                    txtListar.append("   ");
                    txtListar.append("User");
                    txtListar.append("       ");
                    txtListar.append("Password");
                    txtListar.append("\n");
                    while (consulta.next()){
                        txtListar.append(consulta.getString(1));
                        txtListar.append("                 ");
                        txtListar.append(consulta.getString(2));
                        txtListar.append("          ");
                        txtListar.append(consulta.getString(3));
                        txtListar.append("\n");
                    }
                    conector.desconectar();
                }catch (SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText("");
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText("");
                try{
                    conexion = conector.conectar();
                    PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM usuarios WHERE user =?");
                    buscar.setString(1, txtBuscar.getText().trim());
                    ResultSet consulta = buscar.executeQuery();

                    if(txtBuscar.getText().isEmpty()){
                        Login login = new Login();
                        login.faltaDatos();
                    }else{
                        if(consulta.next()){
                            txtListar.append(consulta.getString(1));
                            txtListar.append("       ");
                            txtListar.append(consulta.getString(2));
                            txtListar.append("     ");
                            txtListar.append(consulta.getString(3));
                        }else{
                            Login login = new Login();
                            login.noExiste();
                        }
                    }
                    conector.desconectar();
                }catch(SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnModificarBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    PreparedStatement traerModificar = conexion.prepareStatement("SELECT * FROM usuarios WHERE user =?");
                    traerModificar.setString(1, txtBuscar.getText().trim());
                    ResultSet consulta = traerModificar.executeQuery();
                    if(txtBuscar.getText().isEmpty()){
                        Login login = new Login();
                        login.faltaDatos();
                    }else{
                        if(consulta.next()){
                            txtName.setText(consulta.getString(2));
                            txtPsw1.setText(consulta.getString(3));
                        }else{
                            Login login = new Login();
                            login.noExiste();
                        }
                    }
                    conector.desconectar();
                }catch (SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    String usuario = txtBuscar.getText().trim();
                    PreparedStatement modificar = conexion.prepareStatement("UPDATE usuarios SET user=?, psw =? WHERE user ="+ usuario);
                    if (txtPsw1.getPassword().length== 0 || txtPsw2.getPassword().length==0 || txtName.getText().isEmpty()){
                        Login login = new Login();
                        login.faltaDatos();

                    }else{
                        if(String.valueOf(txtPsw1.getPassword()).equals(String.valueOf(txtPsw2.getPassword()))){
                            modificar.setString(1, txtName.getText());
                            modificar.setString(2, String.valueOf(txtPsw1.getPassword()));
                            modificar.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Usuario modificado con exito");

                        }else{
                            JOptionPane.showMessageDialog(null,"Contraseñas no coinciden");
                        }
                    }
                    System.out.println(String.valueOf(txtPsw1.getPassword()));
                    System.out.println(String.valueOf(txtPsw2.getPassword()));
//                    modificar.executeUpdate();
                    conector.desconectar();
                }catch (SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public void tabla(){
        Tabla table = new Tabla();
        table.setContentPane(new Tabla().panel);
        table.setVisible(true);
        table.setSize(800,700);
        table.setLocationRelativeTo(null);
        table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
