package com.example.usuario.wantfood;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView tvHoraM,tvMensaje,tvNameUser;
    private CircleImageView ciFotoPerfil1;

    public HolderMensaje(View itemView) {
        super(itemView);
        iniciar();
    }


    public void iniciar(){
        tvNameUser = (TextView) itemView.findViewById(R.id.tvNameUser);
        tvMensaje = (TextView) itemView.findViewById(R.id.tvMensaje);
        tvHoraM = (TextView) itemView.findViewById(R.id.tvHoraM);
        ciFotoPerfil1 = (CircleImageView) itemView.findViewById(R.id.ciFotoPerfil);


    }

    public TextView getTvHoraM() {
        return tvHoraM;
    }

    public void setTvHoraM(TextView tvHoraM) {
        this.tvHoraM = tvHoraM;
    }

    public TextView getTvMensaje() {
        return tvMensaje;
    }

    public void setTvMensaje(TextView tvMensaje) {
        this.tvMensaje = tvMensaje;
    }

    public TextView getTvNameUser() {
        return tvNameUser;
    }

    public void setTvNameUser(TextView tvNameUser) {
        this.tvNameUser = tvNameUser;
    }

    public CircleImageView getCiFotoPerfil1() {
        return ciFotoPerfil1;
    }

    public void setCiFotoPerfil1(CircleImageView ciFotoPerfil1) {
        this.ciFotoPerfil1 = ciFotoPerfil1;
    }
}
