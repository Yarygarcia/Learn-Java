import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FromEmpleado extends JFrame{
    Conector conector = Conector.getInstance();
    Connection conexion;
    private JPanel panel;
    private JTextField txtNombre;
    private  JSpinner txtEdad;
    private JComboBox combCountry;
    private JSlider sliderHoras;
    private JRadioButton btnFemenino;
    private JRadioButton btnMasculino;
    private JRadioButton btnOtro;
    private JRadioButton btnNoDecir;
    private JButton btnRegistrar;
    private JTextArea txtInformacion;
    private JButton btnListar;
    private JButton btnVerificar;
    private JButton btnNew;
    ButtonGroup grupo = new ButtonGroup();

    public FromEmpleado() throws SQLException {
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    PreparedStatement verificar = conexion.prepareStatement("SELECT * FROM empleados");
                    ResultSet consulta = verificar.executeQuery();
                    if(consulta.next()){
                        txtInformacion.setText("Sí hay datos en la BD");
                    }else{

                        txtInformacion.setText("No hay datos en la BD");
                    }
                   conector.desconectar();
                }catch (SQLException ex1){
                    System.out.println(ex1.getMessage());
                }
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conexion = conector.conectar();
                    PreparedStatement insertar = conexion.prepareStatement("INSERT INTO empleados VALUES(?,?,?,?,?,?)");
                    insertar.setInt(1, 0);
                    insertar.setString(2, txtNombre.getText());
                    insertar.setInt(3, Integer.parseInt(txtEdad.getValue().toString()));
                    insertar.setString(4, combCountry.getSelectedItem().toString());
                    insertar.setFloat(5, sliderHoras.getValue());
//                    grupo.add(btnFemenino);
//                    grupo.add(btnMasculino);
//                    grupo.add(btnNoDecir);
//                    grupo.add(btnOtro);
                    if(btnFemenino.isSelected()){
                        insertar.setString(6, btnFemenino.getText());
                    }
                    else if(btnMasculino.isSelected()){
                        insertar.setString(6, btnMasculino.getText());
                    }
                    else if(btnOtro.isSelected()){
                        insertar.setString(6, btnOtro.getText());
                    }
                    else if(btnNoDecir.isSelected()){
                        insertar.setString(6, btnNoDecir.getText());
                    }
                    //insertar.setString(6,grupo.getSelection().getGroup().getSelection().getClass().toString());
//                    insertar.setString(6, btnFemenino.getText());
//                    insertar.setString(6, btnMasculino.getText());
//                    insertar.setString(6, btnNoDecir.getText());
//                    insertar.setString(6, btnOtro.getText());
                    insertar.executeUpdate();
                    conector.desconectar();
                }catch (SQLException ex2 ){
                    System.out.println(ex2.getMessage());
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    txtNombre.setText("");
                    txtEdad.setValue(0);
                    sliderHoras.setValue(24);
                    combCountry.setSelectedIndex(0);
                    grupo.add(btnFemenino);
                    grupo.add(btnMasculino);
                    grupo.add(btnNoDecir);
                    grupo.add(btnOtro);
                    grupo.clearSelection();
                }catch (Exception ex3){
                    System.out.println(ex3.getMessage());
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInformacion.setText(" ");
                try{
                    conexion = conector.conectar();
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM empleados");
                    ResultSet listarConsulta = consulta.executeQuery();
                    while(listarConsulta.next()){
                        txtInformacion.append(listarConsulta.getString(1));
                        txtInformacion.append("       ");
                        txtInformacion.append(listarConsulta.getString(2));
                        txtInformacion.append("       ");
                        txtInformacion.append(listarConsulta.getString(3));
                        txtInformacion.append("       ");
                        txtInformacion.append(listarConsulta.getString(4));
                        txtInformacion.append("       ");
                        txtInformacion.append(listarConsulta.getString(5));
                        txtInformacion.append("       ");
                        txtInformacion.append(listarConsulta.getString(6));
                        txtInformacion.append("\n");
                    }
                    conector.desconectar();
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public static void main(String []args) throws SQLException {
        FromEmpleado empleado = new FromEmpleado();
        empleado.setContentPane(new FromEmpleado().panel);
        empleado.setTitle("Empleados");
        empleado.setSize(950,950);
        empleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        empleado.setVisible(true);
        empleado.setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
