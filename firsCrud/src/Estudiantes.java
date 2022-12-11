import com.mysql.cj.xdevapi.PreparableStatement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Estudiantes extends JFrame{
    Connection conexion;
    PreparedStatement ps;
    DefaultListModel modelo = new DefaultListModel();
    Statement statement;
    ResultSet result;
    private JPanel panel;
    private JTextField id;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField edad;
    private JTextField telefono;
    private JTextField carrera;
    private JButton agregarBtn;
    private JList lista;
    private JButton listarBtn;

    public static void main (String[] args){
        Estudiantes estudiante = new Estudiantes();
        estudiante.setBounds(500,250, 100, 90);
        estudiante.setContentPane(new Estudiantes().panel);
        estudiante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estudiante.setVisible(true);
        estudiante.pack();

    }
    public void listar() throws SQLException {

        conectar();
        lista.setModel(modelo);
        statement = conexion.createStatement();
        result = statement.executeQuery("SELECT id, nombre, apellido FROM estudiante");
        modelo.removeAllElements();
        while (result.next()){
            modelo.addElement(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
        }
    }

    public void insertar() throws SQLException {
        conectar();
        ps = conexion.prepareStatement("INSERT INTO estudiante VALUES(?,?,?,?,?,?)");
        ps.setInt(1, Integer.parseInt(id.getText()));
        ps.setString(2, nombre.getText());
        ps.setString(3, apellido.getText());
        ps.setInt(4, Integer.parseInt(edad.getText()));
        ps.setInt(5, Integer.parseInt(telefono.getText()));
        ps.setString(6, carrera.getText());
        if(ps.executeUpdate() >0){
            lista.setModel(modelo);
            modelo.removeAllElements();
            modelo.addElement("Inserción  exitosa!!!");

            id.setText("");
            nombre.setText("");
            apellido.setText("");
            edad.setText("");
            telefono.setText("");
            carrera.setText("");
        }
    }
    public Estudiantes(){
        listarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public void conectar(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes", "root","");
            System.out.println("Conexión exitosa!!!");

        }catch(Exception e ){
            throw new RuntimeException(e);
        }
    }
}

