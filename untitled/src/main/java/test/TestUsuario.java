package test;

import datos.UsuarioDAO;
import domain.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestUsuario extends JFrame{
    private JTextField txtUser;
    private JButton REGISTRARButton;
    private JButton LISTARButton;
    private JButton LIMPIARButton;
    private JTextArea txtListar;
    private JTextField txtBuscar;
    private JButton ModificarBuscarButton;
    private JButton BUSCARButton;
    private JButton MODIFICARButton;
    private JPanel panel;
    private JPasswordField txtPsw;
    private JButton ELIMINARButton;
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public TestUsuario() {
        REGISTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String user = txtUser.getText();
                    String psw = new String(txtPsw.getPassword());
                    Usuario usuario = new Usuario(user, psw);
                    usuarioDAO.crear(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        LISTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText("");
                try{
                    usuarioDAO.listar().stream().forEach(n -> txtListar.append(String.valueOf(n)));
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        LIMPIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    txtListar.setText("");
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtBuscar.getText());
                    Usuario usuario = new Usuario(id);
                    usuarioDAO.buscar(usuario);
                    txtListar.setText(usuario.toString());
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtBuscar.getText());
                    Usuario usuario = new Usuario(id);
                    usuarioDAO.eliminar(usuario);
                    JOptionPane.showMessageDialog(null, "Usuariro eliminado con exito");
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        ModificarBuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtBuscar.getText());
                    Usuario usuario = new Usuario(id);
                    usuarioDAO.buscar(usuario);
                    txtUser.setText(usuario.getUser());
                    txtPsw.setText(usuario.getPassword());
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        MODIFICARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtBuscar.getText());
                    String user = txtUser.getText();
                    String psw = String.valueOf(txtPsw.getPassword());
                    Usuario usuario = new Usuario(id, user,psw);
                    usuarioDAO.actualizar(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario actualizado con exito!!");
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public static void main(String[]args){
        TestUsuario testUsuario = new TestUsuario();
        testUsuario.setVisible(true);
        testUsuario.setContentPane(new TestUsuario().panel);
        testUsuario.setSize(650,500);
        testUsuario.setLocationRelativeTo(null);
        testUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
