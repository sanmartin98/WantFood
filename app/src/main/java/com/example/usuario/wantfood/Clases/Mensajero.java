package com.example.usuario.wantfood.Clases;

/**
 * Created by Usuario on 11/05/2018.
 */

public class Mensajero {

    /////////////////////////////////////////////////
    //VARIABLES
    ////////////////////////////////////////////////

    private String nombre;
    private String cedula;
    private String placa;
    private String email;

    /////////////////////////////////////////////////
    //CONSTRUCTORES
    ////////////////////////////////////////////////


    public Mensajero() {
    }

    public Mensajero(String nombre, String cedula, String placa, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.placa = placa;
        this.email = email;
    }

    /////////////////////////////////////////////////
    //METODOS
    ////////////////////////////////////////////////


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
