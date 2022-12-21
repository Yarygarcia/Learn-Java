import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
    private JTextField txtBuscar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnBuscarModificar;
    private JTable table1;
    private JButton traerDatosButton;


    public static void main(String[]args){
        JframeConector jframeConector = new JframeConector();
        jframeConector.setTitle("Registro estudiantes");
        jframeConector.setContentPane(new JframeConector().panel1);
        jframeConector.setSize(850,400);
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
                    JOptionPane.showMessageDialog(null, "Empleado Agregado correctamente");
                    txtNombre.setText("");
                    txtTel.setText("");
                    combFacultad.setSelectedIndex(0);
                    conector.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error, no se pudo agregar empleado");
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
                    combFacultad.setSelectedIndex(0);
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
                    while (consultar.next()){
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
                    JOptionPane.showMessageDialog(null, "Error al listar datos  :( ");
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
                        JOptionPane.showMessageDialog(null,"Sí hay datos!!   en la base de datos" );
                    }else{
                        JOptionPane.showMessageDialog(null,"No hay datos :(   en la base de datos" );
                    }
                    conector.desconectar();
                }catch (SQLException e1){
                    txtInformacion.append("Error al verificar datos  :(");
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    PreparedStatement eliminar = conexion.prepareStatement("DELETE FROM empeados WHERE id=?");
                    eliminar.setString(1, txtBuscar.getText().trim());
                    eliminar.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
                    txtInformacion.setText("");
                    conector.desconectar();
                }catch(SQLException e2){
                    JOptionPane.showMessageDialog(null, "Error al eliminar empleado  :(");
                    System.out.println(e2.getMessage());
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInformacion.setText("");
                try{
                    conexion = conector.conectar();
                    PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM empeados WHERE id = ?");
                    buscar.setString(1, txtBuscar.getText());
                    ResultSet buscador = buscar.executeQuery();
                    if(buscador.next()){
                        txtInformacion.append(buscador.getString(1));
                        txtInformacion.append("      ");
                        txtInformacion.append(buscador.getString(2));
                        txtInformacion.append("   ");
                        txtInformacion.append(buscador.getString(3));
                        txtInformacion.append("   ");
                        txtInformacion.append(buscador.getString(4));
                        txtInformacion.append("\n");
                    }else{
                        JOptionPane.showMessageDialog(null, "Empleado no econtrado  :(");
                    }
                    conector.desconectar();
                }catch(SQLException e3){
                    JOptionPane.showMessageDialog(null, "Error al buscar emepleado  :(");
                    System.out.println(e3.getMessage());
                }
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    String idEmpleado = txtBuscar.getText();
                    PreparedStatement actualizar = conexion.prepareStatement("UPDATE empeados SET nombre = ?, telefono = ?, profesion = ? WHERE  id =" + idEmpleado);
                    actualizar.setString(1, txtNombre.getText());
                    actualizar.setInt(2, Integer.parseInt(txtTel.getText()));
                    actualizar.setString(3, combFacultad.getSelectedItem().toString());
                    actualizar.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Empleado modificado correctamente");
                    txtNombre.setText("");
                    txtTel.setText("");
                    combFacultad.setSelectedIndex(0);
                    conector.desconectar();
                }catch(SQLException exception){
                    JOptionPane.showMessageDialog(null, "Error al modificar empleado  :(");
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnBuscarModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM empeados WHERE  id =?");
                    seleccionar.setString(1, txtBuscar.getText());
                    ResultSet consulta = seleccionar.executeQuery();
                    if(consulta.next()){
                        txtNombre.setText(consulta.getString(2));
                        txtTel.setText(consulta.getString(3));
                        combFacultad.setSelectedItem(consulta.getString(4));
                    }else{
                        JOptionPane.showMessageDialog(null, "No existe empleado");
                    }
                    conector.desconectar();
                }catch (SQLException ex5){
                    JOptionPane.showMessageDialog(null, "Error al traer empledo  :(");
                    System.out.println(ex5.getMessage());
                }
            }
        });
        traerDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conexion = conector.conectar();
                    DefaultTableModel modelo = new DefaultTableModel();
                    table1.setModel(modelo);
                    PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM empeados");
                    ResultSet consulta = seleccionar.executeQuery();
                    ResultSetMetaData datos = consulta.getMetaData();
                    int numeroColumnas = datos.getColumnCount();

                    modelo.addColumn("Identificacion");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Profesión");

                    while(consulta.next()){
                        Object arreglo [] = new Object[numeroColumnas];
                        for(int i = 0; i <numeroColumnas; i++){
                            arreglo[i] = consulta.getObject(i+1);
                        }
                        modelo.addRow(arreglo);
                    }

                    conector.desconectar();
                }catch (Exception exception){
                    System.out.println(exception);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
