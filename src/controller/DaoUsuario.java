package controller;

/**
 *
 * @author sebas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Conexion;
import model.Usuarios;

public class DaoUsuario {
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuarios login(String usuario, String contrasena){
        Usuarios us = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' and contrasena ='"+contrasena+"'";
        
        try { 
            conection = conexion.conectar();
            ps = conection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                us.setId_usuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setTelefono(rs.getString(4));
                us.setCorreo(rs.getString(5));
                us.setRol(rs.getString(6));
                us.setUsuario(rs.getString(7));
                us.setContrasena(rs.getString(8));
                us.setDocumento(rs.getString(9));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return us;
    }
    
    public boolean insertar(Usuarios usuario){

        String sql = "INSERT INTO usuarios (nombre, apellido, telefono, correo, rol, usuario, contrasena, documento) VALUES (?, ?, ? ,? ,? ,?, ?, ?)";
        try {

            conection = conexion.conectar();

            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getTelefono());
            preparedStatement.setString(4, usuario.getCorreo());
            preparedStatement.setString(5, usuario.getRol());
            preparedStatement.setString(6, usuario.getUsuario());
            preparedStatement.setString(7, usuario.getContrasena());
            preparedStatement.setString(8, usuario.getDocumento());

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
    
    public List listarUsuarios(){
        List<Usuarios> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                Usuarios usuario = new Usuarios();
                usuario.setId_usuario(resultSet.getInt(1));
                usuario.setNombre(resultSet.getString(2));
                usuario.setApellido(resultSet.getString(3));
                usuario.setTelefono(resultSet.getString(4));
                usuario.setCorreo(resultSet.getString(5));
                usuario.setRol(resultSet.getString(6));
                usuario.setUsuario(resultSet.getString(7));
                usuario.setContrasena(resultSet.getString(8));
                usuario.setDocumento(resultSet.getString(9));
                
                listaUsuarios.add(usuario);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
                
        return listaUsuarios;
    }
    
    public boolean editarUsuario(Usuarios usuario){
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, telefono = ?, correo = ?, rol = ?, usuario = ?, contrasena = ?, documento = ? WHERE id = ?";
        try {

            conection = conexion.conectar();

            preparedStatement = conection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getTelefono());
            preparedStatement.setString(4, usuario.getCorreo());
            preparedStatement.setString(5, usuario.getRol());
            preparedStatement.setString(6, usuario.getUsuario());
            preparedStatement.setString(7, usuario.getContrasena());
            preparedStatement.setString(8, usuario.getDocumento());
            preparedStatement.setInt(9, usuario.getId_usuario());

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
    
    public boolean eliminarUsuario(Usuarios usuario){
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {

            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, usuario.getId_usuario());
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
    
    public boolean buscarUsuario(Usuarios usuario){
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, usuario.getId_usuario());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                usuario.setId_usuario(resultSet.getInt(1));
                usuario.setNombre(resultSet.getString(2));
                usuario.setApellido(resultSet.getString(3));
                usuario.setTelefono(resultSet.getString(4));
                usuario.setCorreo(resultSet.getString(5));
                usuario.setRol(resultSet.getString(6));
                usuario.setUsuario(resultSet.getString(7));
                usuario.setContrasena(resultSet.getString(8));
                usuario.setDocumento(resultSet.getString(9));
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