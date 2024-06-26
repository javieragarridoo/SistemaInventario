/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author javie
 */
public class detalleSalida {
    
    int id_detalle;
    int id_salida;
    int id_recibimiento;
    int cantidad;
    double importe;

    public detalleSalida() {
    }

    public detalleSalida(int id_detalle, int id_salida, int id_recibimiento, int cantidad, double importe) {
        this.id_detalle = id_detalle;
        this.id_salida = id_salida;
        this.id_recibimiento = id_recibimiento;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
    }

    public int getId_recibimiento() {
        return id_recibimiento;
    }

    public void setId_recibimiento(int id_recibimiento) {
        this.id_recibimiento = id_recibimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }


}
