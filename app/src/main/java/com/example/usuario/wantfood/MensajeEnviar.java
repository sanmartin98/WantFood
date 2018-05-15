package com.example.usuario.wantfood;

import java.util.Map;

public class MensajeEnviar extends Mensaje {

    private Map hora;

    public MensajeEnviar(Map hora) {
        this.hora = hora;
    }

    public MensajeEnviar() {

    }

    public MensajeEnviar(String mensaje, String userName) {
        super(mensaje, userName);

    }


}

