package personas;

import interfaces.EmpleadoImplementacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class JFrameEmpleado extends JFrame {

    private JPanel panel;
    private JTextField txtNombre;
    private JComboBox combCargo;
    private JButton bntRegistar;
    private JButton btnNew;
    private JTextArea textListar;
    private JButton btnListar;
    private JButton btnVerificar;
    private JTextField txtBuscar;
    private JButton btnEliminar;
    private JButton btnBuscarModificar;
    private JButton btnModificar;

    private EmpleadoImplementacion empleadoImplementacion = new EmpleadoImplementacion();

    public JFrameEmpleado() throws SQLException {
        bntRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleado empleado = new Empleado(txtNombre.getText(), combCargo.getSelectedItem().toString());
                    empleadoImplementacion.regitrar(empleado);
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    limpiar();
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    empleadoImplementacion.Verificar();
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleado empleado = new Empleado(txtNombre.getText(), combCargo.getSelectedItem().toString());
                    empleadoImplementacion.modificar(empleado, Integer.parseInt(txtBuscar.getText()));
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                    limpiar();
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    limpiar();
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnBuscarModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleado empleado = new Empleado();
                    if(txtBuscar.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Ingresa el id");
                    }else{
                        empleado.setId(Integer.parseInt(txtBuscar.getText()));
                        empleadoImplementacion.buscar(empleado);

                        txtNombre.setText(empleado.getNombre());
                        combCargo.setSelectedItem(empleado.getCargo());
                    }

                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleado empleado = new Empleado();
                    empleadoImplementacion.eliminar(empleado, Integer.parseInt(txtBuscar.getText().trim()));
                    JOptionPane.showMessageDialog(null, "Elmpleado eliminado");
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
    }
    public void limpiar(){
        txtNombre.setText("");
        combCargo.setSelectedIndex(0);
        txtBuscar.setText("");
    }
    public  static void main(String [] args) throws SQLException {
        JFrameEmpleado jFrameEmpleado = new JFrameEmpleado();
        jFrameEmpleado.setContentPane(new JFrameEmpleado().panel);
        jFrameEmpleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameEmpleado.setVisible(true);
        jFrameEmpleado.setTitle("Empleados");
        jFrameEmpleado.setSize(800, 500);
        jFrameEmpleado.setLocationRelativeTo(null);
    }
}
