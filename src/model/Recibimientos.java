/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author javie
 */
public class Recibimientos {
    
    int id_recibimiento;
    String nombre_producto;
    int stock;
    int id_categoria;
    Date fecha;
    int id_proveedor;
    double precio_recibimiento;
    double precio_venta;
    double total;

    public Recibimientos() {
    }

    public Recibimientos(int id_recibimiento, String nombre_producto, int stock, int id_categoria, Date fecha, int id_proveedor, double precio_recibimiento, double precio_venta, double total) {
        this.id_recibimiento = id_recibimiento;
        this.nombre_producto = nombre_producto;
        this.stock = stock;
        this.id_categoria = id_categoria;
        this.fecha = fecha;
        this.id_proveedor = id_proveedor;
        this.precio_recibimiento = precio_recibimiento;
        this.precio_venta = precio_venta;
        this.total = total;
    }

    public int getId_recibimiento() {
        return id_recibimiento;
    }

    public void setId_recibimiento(int id_recibimiento) {
        this.id_recibimiento = id_recibimiento;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public double getPrecio_recibimiento() {
        return precio_recibimiento;
    }

    public void setPrecio_recibimiento(double precio_recibimiento) {
        this.precio_recibimiento = precio_recibimiento;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
