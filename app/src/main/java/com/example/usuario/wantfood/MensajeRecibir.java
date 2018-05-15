package com.example.usuario.wantfood;

public class MensajeRecibir extends Mensaje {

    private Long hora;

    public MensajeRecibir(Long hora) {
        this.hora = hora;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibir(String mensaje, String userName) {

        super(mensaje, userName);

    }

    public MensajeRecibir() {

    }
}
