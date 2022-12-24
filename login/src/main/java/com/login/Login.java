package com.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame{

    private JPanel panel;
    private JButton btnIngresar;
    private JButton btnRegistrar;
    private JTextField txtUser;
    private JPasswordField txtPsw;

    Conexion conector = Conexion.getInstance();
    Connection conexion;
    static Login login = new Login();

    public Login() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuarios();
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUsuarios();
            }
        });
    }

    public static void main(String[]args) throws SQLException {

        login.setContentPane(new Login().panel);
        login.setVisible(true);
        login.setTitle("Login");
        login.setSize(490, 495);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void registrarUsuarios(){
        if (txtUser.getText().isEmpty() || txtPsw.getPassword().length==0){
                faltaDatos();
        }else{
            try{
                conexion = conector.conectar();
                PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM usuarios WHERE user = ? ");
                buscar.setString(1, txtUser.getText().trim());
                ResultSet consulta = buscar.executeQuery();
                if(consulta.next()){
                    existe();
                    limpiar();
                }else{
                    PreparedStatement insertar = conexion.prepareStatement("INSERT INTO  usuarios VALUES(?,?,?)");
                    insertar.setInt(1,0);
                    insertar.setString(2, txtUser.getText());
                    insertar.setString(3, String.valueOf(txtPsw.getPassword()));
                    insertar.executeUpdate();
                    registroExitoso();
                    limpiar();
                }
                conector.desconectar();
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public void loginUsuarios(){
        if(txtUser.getText().isEmpty() || txtPsw.getPassword().length==0){
            faltaDatos();
        }else {
            try {
                conexion = conector.conectar();
                PreparedStatement buscar = conexion.prepareStatement("SELECT *  FROM usuarios WHERE user =? AND psw =?");
                buscar.setString(1, txtUser.getText());
                buscar.setString(2, String.valueOf(txtPsw.getPassword()));

                ResultSet consulta = buscar.executeQuery();

                if (consulta.next()) {
                    logueoExitoso();
                    limpiar();
                    login.setVisible(false);
                    Tabla table = new Tabla();
                    table.tabla();
//                    Tabla tabla = new Tabla();
//                    tabla.setVisible(true);
//                    tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    tabla.setLocationRelativeTo(null);

                } else {
                    noExiste();
                    limpiar();
                }
                conector.desconectar();
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void faltaDatos(){
            Icon icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/cancelar.png"));
            JOptionPane.showMessageDialog(rootPane, "Hay campos vacios","Mensaje", JOptionPane.PLAIN_MESSAGE, icon );
    }

    public void registroExitoso(){
        Icon icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/deacuerdo.png"));
        JOptionPane.showMessageDialog(rootPane, "Usuario registrado con exito","Mensaje", JOptionPane.PLAIN_MESSAGE, icon );
    }
    public void logueoExitoso(){
        Icon icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/deacuerdo.png"));
        JOptionPane.showMessageDialog(rootPane, "Logueo Exitoso","Mensaje", JOptionPane.PLAIN_MESSAGE, icon );
    }

    public  void existe(){
        Icon icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/cancelar.png"));
        JOptionPane.showMessageDialog(rootPane, "Usuario ya existe","Mensaje", JOptionPane.PLAIN_MESSAGE, icon );
    }
    public void noExiste(){
        Icon icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/cancelar.png"));
        JOptionPane.showMessageDialog(rootPane, "Usuario no existe","Mensaje", JOptionPane.PLAIN_MESSAGE, icon );
    }

    public void limpiar(){
        txtUser.setText("");
        txtPsw.setText("");
    }
}
