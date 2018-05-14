package com.example.usuario.wantfood;

import java.util.Map;

public class MensajeEnviar extends Mensaje {

    private Map hora;

    public MensajeEnviar(Map hora) {
        this.hora = hora;
    }

    public MensajeEnviar() {

    }

    public MensajeEnviar(String mensaje, String userName, String fotoPerfil, Map hora) {
        super(mensaje, userName, fotoPerfil);
        this.hora = hora;
    }

    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}

