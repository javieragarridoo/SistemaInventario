/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Conexion;
import model.Salidas;

/**
 *
 * @author javie
 */
public class DaoSalida {
    
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public boolean insertar(Salidas salida){
        
        String sql = "INSERT INTO salidas (numSalida, id_cliente, fecha, subtotal, iva, total) VALUES (?, ? ,? ,? ,?, ?)";
        try {
            
            conection = conexion.conectar();
            
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, salida.getNumSalida());
            preparedStatement.setInt(2, salida.getId_cliente());
            preparedStatement.setDate(3, salida.getFecha());
            preparedStatement.setDouble(4, salida.getIva());
            preparedStatement.setDouble(5, salida.getSubtotal());
            preparedStatement.setDouble(6, salida.getTotal());
                                                
            int number = preparedStatement.executeUpdate();
            
            if(number != 0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public String numSalida(){
        String numero = "";
        String sql = "select max(id_salidas) from salidas";
        try {

            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
           resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                numero = resultSet.getString(1);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }

        return numero;
    }
}
