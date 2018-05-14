package com.example.usuario.wantfood;

public class Mensaje {
    private String mensaje;
    private String userName;
    private String fotoPerfil;

    public Mensaje(){

    }


    public Mensaje(String mensaje, String userName, String fotoPerfil) {
        this.mensaje = mensaje;
        this.userName = userName;
        this.fotoPerfil = fotoPerfil;
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



    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
