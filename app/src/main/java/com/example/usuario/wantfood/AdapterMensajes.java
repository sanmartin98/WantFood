package com.example.usuario.wantfood;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.wantfood.Fragments.ChatClienteFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje> {

    private List<MensajeRecibir> mensajeList = new ArrayList<>();
    private Context c;

    public AdapterMensajes(Context c) {
        this.c = c;
    }

    public void addMensaje(MensajeRecibir m){
        mensajeList.add(m);
        notifyItemInserted(mensajeList.size());
    }

    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(HolderMensaje holder, int position) {
        holder.getTvNameUser().setText(mensajeList.get(position).getUserName());
        holder.getTvMensaje().setText(mensajeList.get(position).getMensaje());

        Long codigoHora = mensajeList.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        holder.getTvHoraM().setText(sdf.format(d));

    }

    @Override
    public int getItemCount() {
        return mensajeList.size();
    }
}
