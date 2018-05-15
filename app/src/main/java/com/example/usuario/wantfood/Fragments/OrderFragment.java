package com.example.usuario.wantfood.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.wantfood.Clases.Pedido;
import com.example.usuario.wantfood.ManejoUser;
import com.example.usuario.wantfood.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class OrderFragment extends Fragment {

    private TextView tvPedido, tvPrecio, tvCliente, tvDir, tvFecha, tvEstado;
    private Button btnEstado, btnChatCliente, btnChatDespachador;
    private View view;
    private String idPedido;
    private ManejoUser mn = new ManejoUser();
    private Pedido pedido = new Pedido();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order, container, false);
        mn.inicializatedFireBase();
        if(getArguments() != null){
            idPedido = getArguments().getString("IdPedido");
        }

        init();
        selectData();

        btnChatCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatClienteFragment chatClienteFragment;
                chatClienteFragment = new ChatClienteFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id",idPedido);
                chatClienteFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,chatClienteFragment).commit();
            }
        });

        btnChatDespachador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatDespachadorFragment chatDespachadorFragment;
                chatDespachadorFragment = new ChatDespachadorFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id",idPedido);
                chatDespachadorFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,chatDespachadorFragment).commit();
            }
        });

        return view;
    }

    private void selectData() {
        mn.databaseReference.child("Pedidos").child(idPedido).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pedido = dataSnapshot.getValue(Pedido.class);
                if(pedido.getEstado().toString().equals("activo")) changeText();
                else {
                    changeText();
                    enableBtn();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void init(){
        tvPedido = (TextView) view.findViewById(R.id.tvPedido);
        tvPrecio = (TextView) view.findViewById(R.id.tvPrecio);
        tvCliente = (TextView) view.findViewById(R.id.tvClienteOrden);
        tvDir = (TextView) view.findViewById(R.id.tvDireccion);
        tvFecha = (TextView) view.findViewById(R.id.tvFecha);
        tvEstado = (TextView) view.findViewById(R.id.tvEstado);
        btnEstado = (Button) view.findViewById(R.id.btnCambiarEstado);
        btnChatCliente = (Button) view.findViewById(R.id.btnChatCliente);
        btnChatDespachador = (Button) view.findViewById(R.id.btnChatDespachador);
    }

    private void changeText(){
        tvPedido.setText(pedido.getProducto());
        tvPrecio.setText(pedido.getPrecio() + "");
        tvCliente.setText(pedido.getCliente());
        tvDir.setText(pedido.getDireccion());
        tvFecha.setText(pedido.getFecha());
        tvEstado.setText(pedido.getEstado());
    }

    private void enableBtn(){
        btnEstado.setEnabled(false);
        btnChatCliente.setEnabled(false);
        btnChatDespachador.setEnabled(false);
    }

}
