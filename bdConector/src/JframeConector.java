import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JframeConector extends JFrame {
    private JButton conectarALaBaseButton;
    Conector conector = new Conector();
    Connection conexion;
    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField txtTel;
    private JComboBox combFacultad;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnListar;
    private JTextArea txtInformacion;
    private JButton btnVerificar;


    public static void main(String[]args){
        JframeConector jframeConector = new JframeConector();
        jframeConector.setTitle("Registro estudiantes");
        jframeConector.setContentPane(new JframeConector().panel1);
        jframeConector.setSize(800,400);
        jframeConector.setLocationRelativeTo(null);
        jframeConector.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframeConector.setVisible(true);
    }

    public JframeConector() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conexion = conector.conectar();
                    PreparedStatement preparedStatement = conexion.prepareStatement("INSERT  INTO empeados values(?,?,?,?)");
                    preparedStatement.setString(1, "0");
                    preparedStatement.setString(2,txtNombre.getText());
                    preparedStatement.setInt(3, Integer.parseInt(txtTel.getText().trim()));
                    preparedStatement.setString(4, combFacultad.getSelectedItem().toString());
                    preparedStatement.executeUpdate();
                    conector.desconectar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    txtNombre.setText("");
                    txtTel.setText("");
                    combFacultad.setSelectedItem("");
                }catch (Exception ex1){
                    throw new RuntimeException(ex1.getMessage());
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInformacion.setText("");
                try{

                    conexion = conector.conectar();
                    PreparedStatement consultor = conexion.prepareStatement("SELECT * FROM empeados");
                    ResultSet consultar = consultor.executeQuery();
                    while(consultar.next()){
                            txtInformacion.append(consultar.getString(1));
                            txtInformacion.append("        ");
                            txtInformacion.append(consultar.getString(2));
                            txtInformacion.append("     ");
                            txtInformacion.append(consultar.getString(3));
                            txtInformacion.append("     ");
                            txtInformacion.append(consultar.getString(4));
                            txtInformacion.append("\n");
                    }
                    conector.desconectar();
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInformacion.setText("");
                try{
                    conexion = conector.conectar();
                    PreparedStatement verificar = conexion.prepareStatement("SELECT * FROM empeados");
                    ResultSet verificador = verificar.executeQuery();
                    if(verificador.next()){
                        txtInformacion.append("Sí hay datos!!   en la base de datos");
                    }else{
                        txtInformacion.append("No hay datos :(   en la base de datos");
                    }

                    conector.desconectar();
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
