package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Clientes;
import model.Conexion;

/**
 *
 * @author sebas
 */
public class DaoCliente {
    Connection conection;
    Conexion conexion = new Conexion();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public boolean insertar(Clientes clientes){
        
        String sql = "INSERT INTO cliente (nombre, apellido, documento, direccion, telefono, correo) VALUES (?, ?, ? ,? ,? ,?)";
        try {
            
            conection = conexion.conectar();
            
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, clientes.getNombre());
            preparedStatement.setString(2, clientes.getApellido());
            preparedStatement.setString(3, clientes.getDocumento());
            preparedStatement.setString(4, clientes.getDireccion());
            preparedStatement.setString(5, clientes.getTelefono());
            preparedStatement.setString(6, clientes.getCorreo());
            
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
        
    public List listarClientes(){
        List<Clientes> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                Clientes clientes = new Clientes();
                clientes.setId_cliente(resultSet.getInt(1));
                clientes.setNombre(resultSet.getString(2));
                clientes.setApellido(resultSet.getString(3));
                clientes.setDocumento(resultSet.getString(4));
                clientes.setDireccion(resultSet.getString(5));
                clientes.setTelefono(resultSet.getString(6));
                clientes.setCorreo(resultSet.getString(7));
                
                listaClientes.add(clientes);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
                
        return listaClientes;
    }
    
    public boolean editarCliente(Clientes cliente){
        String sql = "UPDATE cliente SET nombre = ?, apellido = ?, documento = ?, direccion = ?, telefono = ?, correo = ? WHERE id = ?";
        try {

            conection = conexion.conectar();

            preparedStatement = conection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getDocumento());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setString(5, cliente.getTelefono());
            preparedStatement.setString(6, cliente.getCorreo());
            preparedStatement.setInt(7, cliente.getId_cliente());

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
    
    public boolean eliminarCliente(Clientes clientes){
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {

            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, clientes.getId_cliente());
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
    
    public boolean buscarCliente(Clientes clientes){
        String sql = "SELECT * FROM cliente WHERE documento = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, clientes.getDocumento());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                clientes.setId_cliente(resultSet.getInt(1));
                clientes.setNombre(resultSet.getString(2));
                clientes.setApellido(resultSet.getString(3));
                clientes.setDocumento(resultSet.getString(4));
                clientes.setDireccion(resultSet.getString(5));
                clientes.setTelefono(resultSet.getString(6));
                clientes.setCorreo(resultSet.getString(7));
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
     public boolean buscarClientePorId(Clientes clientes){
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            
            conection = conexion.conectar();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, clientes.getId_cliente());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                clientes.setId_cliente(resultSet.getInt(1));
                clientes.setNombre(resultSet.getString(2));
                clientes.setApellido(resultSet.getString(3));
                clientes.setDocumento(resultSet.getString(4));
                clientes.setDireccion(resultSet.getString(5));
                clientes.setTelefono(resultSet.getString(6));
                clientes.setCorreo(resultSet.getString(7));
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
