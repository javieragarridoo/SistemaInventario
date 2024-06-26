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
public class Salidas {
    
    int id_salidas;
    String numSalida;
    int id_cliente;
    Date fecha;
    double subtotal;
    double iva;
    double total;

    public Salidas() {
    }

    public Salidas(int id_salidas, String numSalida, int id_cliente, Date fecha, double subtotal, double iva, double total) {
        this.id_salidas = id_salidas;
        this.numSalida = numSalida;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public int getId_salidas() {
        return id_salidas;
    }

    public void setId_salidas(int id_salidas) {
        this.id_salidas = id_salidas;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    
    
}
