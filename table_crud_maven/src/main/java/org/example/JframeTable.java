package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class JframeTable extends  JFrame{
    private JPanel panel1;
    private  JTable tabla2;
    private JButton cargarDatosButton;
    Conector conector = Conector.getInstance();
    public JframeTable() {
        cargarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DefaultTableModel modelo = new DefaultTableModel();
                    tabla2.setModel(modelo);
                    Connection conexion = conector.conectar();
                    PreparedStatement seleccion = conexion.prepareStatement("SELECT * FROM  empleados");
                    ResultSet consulta = seleccion.executeQuery();

                    ResultSetMetaData datos = consulta.getMetaData();
                    int cantidadColumnas = datos.getColumnCount();
                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Cargo");

//                    int ancho[] = {10, 30 ,30};
//                    for(int i = 0; i< cantidadColumnas; i++){
//                        tabla2.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
//                    }

                    while(consulta.next()){
                        Object arreglo[] = new Object[cantidadColumnas];
                        for(int i =0; i <cantidadColumnas; i++){
                            arreglo[i] = consulta.getObject(i+1);
                        }
                        modelo.addRow(arreglo);
                    }

                    conector.desconectar();
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public static void main(String []args){
        JframeTable jframeTable = new JframeTable();
        jframeTable.setContentPane(new JframeTable().panel1);
        jframeTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframeTable.setVisible(true);
        jframeTable.setSize(300,200);
        jframeTable.setLocationRelativeTo(null);
    }






}
