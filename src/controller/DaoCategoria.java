/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
/**
 *
 * @author sebas
 */
public class DaoCategoria {
    
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public boolean insertar(Categoria categorias){
        String sql = "INSERT INTO categorias (categoria) VALUES (?)";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, categorias.getNombreCategoria());
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
    
    public List listarCategorias(){
        List<Categoria> listaCategoria = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt(1));
                categoria.setNombreCategoria(resultSet.getString(2));
                listaCategoria.add(categoria);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
                
        return listaCategoria;
    }
    
    public boolean editarCategoria(Categoria categoria){
        String sql = "UPDATE categorias SET categoria = ? WHERE id = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getNombreCategoria());
            preparedStatement.setInt(2, categoria.getIdCategoria());
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
    
    public boolean eliminarCategoria(Categoria categoria){
        String sql = "DELETE FROM categorias WHERE id = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, categoria.getIdCategoria());
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
    
    public boolean buscarCategoria(Categoria categoria){
        String sql = "SELECT * FROM categorias WHERE id = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, categoria.getIdCategoria());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                categoria.setIdCategoria(resultSet.getInt(1));
                categoria.setNombreCategoria(resultSet.getString(2));
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
