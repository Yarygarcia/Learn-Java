import javax.naming.spi.DirectoryManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JframeEstudiante extends JFrame{
    Connection conexion;
    PreparedStatement preparedStatement;
    DefaultListModel model = new DefaultListModel();
    ResultSet resultSet;
    Statement statement;
    private JPanel panel;
    private JTextField textId;
    private JTextField textCareer;
    private JTextField textFullName;
    private JTextField textPhone;
    private JTextField textName;
    private JTextField textAge;
    private JButton btnAdd;
    private JButton btnListar;
    private JList lista;

    public static void main(String[] args){
        JframeEstudiante jframeEstudiante = new JframeEstudiante();
        jframeEstudiante.setContentPane(new JframeEstudiante().panel);
        jframeEstudiante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframeEstudiante.setVisible(true);
        jframeEstudiante.pack();
    }
    public JframeEstudiante() {
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    crear();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    public void listar() throws SQLException {
        conectar();
        statement = conexion.createStatement();
        resultSet = statement.executeQuery("SELECT id, nombre FROM estudiante");
        model.removeAllElements();
        while (resultSet.next()){
            model.addElement(resultSet.getString(1) + " - " + resultSet.getString(2));
        }

    }
    public  void crear() throws SQLException {
        conectar();
        preparedStatement = conexion.prepareStatement("INSERT INTO estudiante VALUES (?,?,?,?,?,?)");
        preparedStatement.setInt(1, Integer.parseInt(textId.getText()));
        preparedStatement.setString(2,textName.getText());
        preparedStatement.setString(3,textFullName.getText());
        preparedStatement.setInt(4, Integer.parseInt(textAge.getText()));
        preparedStatement.setInt(5, Integer.parseInt(textPhone.getText()));
        preparedStatement.setString(6,textCareer.getText());
        if(preparedStatement.executeUpdate() >0){
            lista.setModel(model);
            model.removeAllElements();
            model.addElement("Estudiante insertado correctamente");

            textId.setText("");
            textName.setText("");
            textFullName.setText("");
            textAge.setText("");
            textPhone.setText("");
            textCareer.setText("");
        }
    }

    public  void  conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes", "root", "");
            System.out.println("Conexion exitosa");
        }catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
