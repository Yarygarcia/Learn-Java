import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormTienda extends  JFrame {
    Connection conexion;
    PreparedStatement insertar;
    private JTextField txtName;
    private JTextField txtPrice;
    private JComboBox combOrigen;
    private JTextField txtDateIngreso;
    private JTextField txtDataVencimiento;
    private JButton btnRegister;
    private JButton btnNew;
    private JPanel panel;
    private JButton btnConsultar;
    private JTextField txtListar;

    public FormTienda() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conectar conectar = new Conectar();
                    conexion = conectar.conectar();
                    insertar = conexion.prepareStatement("INSERT INTO productos VALUES(?,?,?,?,?,?)");
                    insertar.setInt(1,0);
                    insertar.setString(2, txtName.getText());
                    insertar.setDouble(3, Double.parseDouble(txtPrice.getText()));
                    insertar.setString(4,combOrigen.getSelectedItem().toString());
                    insertar.setDate(5, Date.valueOf(txtDateIngreso.getText()));
                    insertar.setDate(6, Date.valueOf(txtDataVencimiento.getText()));
                    insertar.executeUpdate();
                    conectar.desconectar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    txtName.setText("");
                    txtPrice.setText("");
                    txtDateIngreso.setText("");
                    txtDataVencimiento.setText("");
                }catch (Exception ex1){
                    throw new RuntimeException(ex1);
                }
            }
        });
    }

    public static void main(String [] args){
        FormTienda formTienda = new FormTienda();
        formTienda.setContentPane(new FormTienda().panel);
        formTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formTienda.setVisible(true);
        formTienda.setTitle("Productos");
        formTienda.setSize(600, 300);
        formTienda.setLocationRelativeTo(null);

    }
}
