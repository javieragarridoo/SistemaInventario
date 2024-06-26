/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Conexion;
import model.Recibimientos;


public class DaoRecibimiento {
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public boolean insertar(Recibimientos recibimiento){
        
        String sql = "INSERT INTO recibimiento (nombre_producto, stock, id_categoria, fecha, id_proveedor, precio_recibimiento, precio_venta, total) VALUES (?, ?, ? ,? ,? ,?, ?, ?)";
        try {
            
            conection = conexion.conectar();
            
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, recibimiento.getNombre_producto());
            preparedStatement.setInt(2, recibimiento.getStock());
            preparedStatement.setInt(3, recibimiento.getId_categoria());
            preparedStatement.setDate(4, recibimiento.getFecha());
            preparedStatement.setInt(5, recibimiento.getId_proveedor());
            preparedStatement.setDouble(6, recibimiento.getPrecio_recibimiento());
            preparedStatement.setDouble(7, recibimiento.getPrecio_venta());
            preparedStatement.setDouble(8, recibimiento.getTotal());
                                                
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
    
    public List listarRecibos(){
        List<Recibimientos> listaRecibos = new ArrayList<>();
        String sql = "SELECT * FROM recibimiento";
        
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                Recibimientos recibos = new Recibimientos();
                
                recibos.setId_recibimiento(resultSet.getInt(1));
                recibos.setNombre_producto(resultSet.getString(2));
                recibos.setStock(resultSet.getInt(3));
                recibos.setId_categoria(resultSet.getInt(4));
                recibos.setFecha(resultSet.getDate(5));
                recibos.setId_proveedor(resultSet.getInt(6));
                recibos.setPrecio_recibimiento(resultSet.getDouble(7));
                recibos.setPrecio_venta(resultSet.getDouble(8));
                recibos.setTotal(resultSet.getDouble(9));
                
                listaRecibos.add(recibos);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
                
        return listaRecibos;
    }
    
    public boolean editarRecibo(Recibimientos recibimiento){
        String sql = "UPDATE recibimiento SET nombre_producto = ?, stock = ?, id_categoria = ?, fecha = ?, id_proveedor = ?, precio_recibimiento = ?, precio_venta = ?, total = ? WHERE id = ?";
        try {

            conection = conexion.conectar();

            preparedStatement = conection.prepareStatement(sql);

            preparedStatement.setString(1, recibimiento.getNombre_producto());
            preparedStatement.setInt(2, recibimiento.getStock());
            preparedStatement.setInt(3, recibimiento.getId_categoria());
            preparedStatement.setDate(4, recibimiento.getFecha());
            preparedStatement.setInt(5, recibimiento.getId_proveedor());
            preparedStatement.setDouble(6, recibimiento.getPrecio_recibimiento());
            preparedStatement.setDouble(7, recibimiento.getPrecio_venta());
            preparedStatement.setDouble(8, recibimiento.getTotal());
            preparedStatement.setInt(9, recibimiento.getId_recibimiento());

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
    
    public boolean eliminarRecibo(Recibimientos recibimientos){
        String sql = "DELETE FROM recibimiento WHERE id = ?";
        try {

            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, recibimientos.getId_recibimiento());
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
    
    public boolean buscarRecibo(Recibimientos recibimientos){
        String sql = "SELECT * FROM recibimiento WHERE id_recibimiento = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, recibimientos.getId_recibimiento());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                recibimientos.setId_recibimiento(resultSet.getInt(1));
                recibimientos.setNombre_producto(resultSet.getString(2));
                recibimientos.setStock(resultSet.getInt(3));
                recibimientos.setId_categoria(resultSet.getInt(4));
                recibimientos.setFecha(resultSet.getDate(5));
                recibimientos.setId_proveedor(resultSet.getInt(6));
                recibimientos.setPrecio_recibimiento(resultSet.getInt(7));
                recibimientos.setPrecio_venta(resultSet.getInt(8));
                recibimientos.setTotal(resultSet.getInt(9));
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
