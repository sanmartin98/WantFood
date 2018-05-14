package com.example.usuario.wantfood.Clases;

import java.util.ArrayList;

/**
 * Created by Usuario on 12/05/2018.
 */

public class Pedido {

    ////////////////////////////////////////////
    //VARIABLES
    ///////////////////////////////////////////

    private String id;
    private int calificacion;
    private String estado;
    private String fecha;
    private String producto;
    private String cliente;
    private String direccion;
    private int precio;

    //////////////////////////////////////////
    //CONSTRUCTORES
    /////////////////////////////////////////


    public Pedido() {
    }

    public Pedido(String id,int calificacion, String estado, String fecha, String producto, String cliente, String direccion, int precio) {
        this.id = id;
        this.calificacion = calificacion;
        this.estado = estado;
        this.fecha = fecha;
        this.producto = producto;
        this.cliente = cliente;
        this.direccion = direccion;
        this.precio = precio;
    }

    ///////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
