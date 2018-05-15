package com.example.usuario.wantfood;

public class Mensaje {
    private String mensaje;
    private String userName;


    public Mensaje(){

    }


    public Mensaje(String mensaje, String userName) {
        this.mensaje = mensaje;
        this.userName = userName;

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




}
