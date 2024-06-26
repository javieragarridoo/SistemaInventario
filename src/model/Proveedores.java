/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author javie
 */
public class Proveedores {
    
    int id_proveedor;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String correo;
    String documento;
    String Rsocial;

    public Proveedores() {
    }

    public Proveedores(int id_proveedor, String nombre, String apellido, String direccion, String telefono, String correo, String documento, String Rsocial) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.documento = documento;
        this.Rsocial = Rsocial;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRsocial() {
        return Rsocial;
    }

    public void setRsocial(String Rsocial) {
        this.Rsocial = Rsocial;
    }
    
    
}
