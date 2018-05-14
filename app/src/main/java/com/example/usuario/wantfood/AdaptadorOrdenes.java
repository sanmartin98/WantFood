package com.example.usuario.wantfood;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.wantfood.Clases.Pedido;

import java.util.ArrayList;

/**
 * Created by Usuario on 13/05/2018.
 */

public class AdaptadorOrdenes extends RecyclerView.Adapter<AdaptadorOrdenes.OrdenesViewHolder> implements View.OnClickListener{

    ArrayList<Pedido> lstPedidos;
    private View.OnClickListener listener;

    public AdaptadorOrdenes(ArrayList<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    @Override
    public OrdenesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listordenes, null, false);
        view.setOnClickListener(this);
        return new OrdenesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrdenesViewHolder holder, int position) {
        holder.tvOrden.setText(lstPedidos.get(position).getProducto());
        holder.tvCliente.setText(lstPedidos.get(position).getCliente());
        holder.tvDir.setText(lstPedidos.get(position).getDireccion());
    }

    @Override
    public int getItemCount() {
        return lstPedidos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class OrdenesViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrden, tvCliente, tvDir;

        public OrdenesViewHolder(View itemView) {
            super(itemView);
            tvOrden = (TextView) itemView.findViewById(R.id.tvOrden);
            tvCliente = (TextView) itemView.findViewById(R.id.tvCliente);
            tvDir = (TextView) itemView.findViewById(R.id.tvDir);

        }
    }
}
