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

public class OrderFragment extends Fragment implements View.OnClickListener {

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
        cargarOrden();

        return view;
    }

    private void cargarOrden() {
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
        btnEstado.setOnClickListener(this);
        btnChatCliente.setOnClickListener(this);
        btnChatDespachador.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCambiarEstado:
                cambiarEstadoPedido();
                break;

            case R.id.btnChatCliente:
                chatCliente();
                break;

            case R.id.btnChatDespachador:
                chatDespachador();
                break;
        }
    }

    private void chatDespachador() {
        ChatDespachadorFragment chatDespachadorFragment;
        chatDespachadorFragment = new ChatDespachadorFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",idPedido);
        chatDespachadorFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,chatDespachadorFragment).commit();
    }

    private void chatCliente() {
        ChatClienteFragment chatClienteFragment;
        chatClienteFragment = new ChatClienteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",idPedido);
        chatClienteFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,chatClienteFragment).commit();
    }

    private void cambiarEstadoPedido(){
        pedido.setEstado("entregado");
        mn.databaseReference.child("Pedidos").child(pedido.getId()).setValue(pedido);
        Toast.makeText(getContext(), "Se ha movido la orden al historial", Toast.LENGTH_SHORT).show();
        Fragment fragment = new ProfileFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
    }


}
