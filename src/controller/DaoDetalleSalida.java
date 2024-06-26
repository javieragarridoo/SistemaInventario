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
public class DaoDetalleSalida {
    
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public boolean insertar(int id_salida, int id_recibimiento, int cantidad, double importe){
        
        String sql = "INSERT INTO detallesalida (id_salida, id_recibimiento, cantidad, importe) VALUES ("+id_salida+ "," + "" + id_recibimiento + ","+cantidad+ ","+importe+")"; 
        try {
            
            conection = conexion.conectar();
            
            preparedStatement = conection.prepareStatement(sql);
                                                
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
    
}
