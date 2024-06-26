/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Conexion {
    Connection con;
    String bd="sistemainventario";
    String url="jdbc:mysql://127.0.0.1/"+bd;
    String user="root";
    String pass="";
    
    public Connection conectar(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return con;
    }
}
