package com.example.usuario.wantfood.Clases;

import java.util.ArrayList;

/**
 * Created by Usuario on 12/05/2018.
 */

public class Pedido {

    ////////////////////////////////////////////
    //VARIABLES
    ///////////////////////////////////////////

    private int calificacion;
    private String estado;
    private String fecha;
    private String producto;

    //////////////////////////////////////////
    //CONSTRUCTORES
    /////////////////////////////////////////


    public Pedido() {
    }

    public Pedido(int calificacion, String estado, String fecha, String producto) {
        this.calificacion = calificacion;
        this.estado = estado;
        this.fecha = fecha;
        this.producto = producto;
    }

    ///////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////


    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
