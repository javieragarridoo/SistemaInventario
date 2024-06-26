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
import model.Proveedores;

/**
 *
 * @author javie
 */
public class DaoProveedor {
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public boolean insertar(Proveedores proveedor){
        
        String sql = "INSERT INTO proveedor (nombre, apellido, direccion, telefono, correo, documento, Rsocial) VALUES (?, ?, ? ,? ,? ,?, ?)";
        try {
            
            conection = conexion.conectar();
            
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, proveedor.getNombre());
            preparedStatement.setString(2, proveedor.getApellido());
            preparedStatement.setString(3, proveedor.getDireccion());
            preparedStatement.setString(4, proveedor.getTelefono());
            preparedStatement.setString(5, proveedor.getCorreo());
            preparedStatement.setString(6, proveedor.getDocumento());
            preparedStatement.setString(7, proveedor.getRsocial());
            
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
    
        public List listarProveedores(){
        List<Proveedores> listaProveedor = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                Proveedores proveedor = new Proveedores();
                proveedor.setId_proveedor(resultSet.getInt(1));
                proveedor.setNombre(resultSet.getString(2));
                proveedor.setApellido(resultSet.getString(3));
                proveedor.setDireccion(resultSet.getString(4));
                proveedor.setTelefono(resultSet.getString(5));
                proveedor.setCorreo(resultSet.getString(6));
                proveedor.setDocumento(resultSet.getString(7));
                proveedor.setRsocial(resultSet.getString(8));

                
                listaProveedor.add(proveedor);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
                
        return listaProveedor;
    }
        
    public boolean buscarProveedor(Proveedores proveedores){
        String sql = "SELECT * FROM proveedor WHERE id_proveedor = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, proveedores.getId_proveedor());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                proveedores.setId_proveedor(resultSet.getInt(1));
                proveedores.setNombre(resultSet.getString(2));
                proveedores.setApellido(resultSet.getString(3));
                proveedores.setDireccion(resultSet.getString(4));
                proveedores.setTelefono(resultSet.getString(5));
                proveedores.setCorreo(resultSet.getString(6));
                proveedores.setDocumento(resultSet.getString(7));
                proveedores.setRsocial(resultSet.getString(8));
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
     public boolean editarProveedor(Proveedores proveedor){
        String sql = "UPDATE proveedor SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ?, documento = ?, Rsocial = ? WHERE id_proveedor = ?";
        try {

            conection = conexion.conectar();

            preparedStatement = conection.prepareStatement(sql);

            preparedStatement.setString(1, proveedor.getNombre());
            preparedStatement.setString(2, proveedor.getApellido());
            preparedStatement.setString(3, proveedor.getDireccion());
            preparedStatement.setString(4, proveedor.getTelefono());
            preparedStatement.setString(5, proveedor.getCorreo());
            preparedStatement.setString(6, proveedor.getDocumento());
            preparedStatement.setString(7, proveedor.getRsocial());
            preparedStatement.setInt(8, proveedor.getId_proveedor());

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
    
    public boolean eliminarProveedor(Proveedores proveedor){
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try {

            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, proveedor.getId_proveedor());
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
    
    public boolean buscarDocumento(Proveedores proveedores){
        String sql = "SELECT * FROM proveedor WHERE documento = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, proveedores.getDocumento());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                proveedores.setId_proveedor(resultSet.getInt(1));
                proveedores.setNombre(resultSet.getString(2));
                proveedores.setApellido(resultSet.getString(3));
                proveedores.setDireccion(resultSet.getString(4));
                proveedores.setTelefono(resultSet.getString(5));
                proveedores.setCorreo(resultSet.getString(6));
                proveedores.setDocumento(resultSet.getString(7));
                proveedores.setRsocial(resultSet.getString(8));
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
