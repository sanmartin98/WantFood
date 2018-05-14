package com.example.usuario.wantfood.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.wantfood.Activitys.Activity_Principal;
import com.example.usuario.wantfood.AdaptadorOrdenes;
import com.example.usuario.wantfood.Clases.Pedido;
import com.example.usuario.wantfood.ManejoUser;
import com.example.usuario.wantfood.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FragmentOrdenes extends Fragment {

    private ArrayList<Pedido> lstPedidos;
    private RecyclerView recyclerPedidos;
    private ManejoUser mn = new ManejoUser();
    private View view;
    private int tOrden;
    private TextView tvOrdenes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_ordenes, container, false);
        mn.inicializatedFireBase();
        if(getArguments() != null){
            tOrden = getArguments().getInt(Activity_Principal.TYPE_ORDER);
        }
        init();
        return view;
    }

    private void init(){
        tvOrdenes = (TextView) view.findViewById(R.id.tvOrdenes);
        lstPedidos = new ArrayList<>();
        recyclerPedidos = view.findViewById(R.id.rvOrdenes);
        recyclerPedidos.setLayoutManager(new LinearLayoutManager(getContext()));
        selectData();

    }

    private ArrayList<Pedido> selectData(){
        lstPedidos.clear();
        mn.databaseReference.child("Pedidos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Llenar lista para ordenes activas
                if (tOrden == 0) {
                    for (DataSnapshot pedidos : dataSnapshot.getChildren()) {
                        Pedido pedido = pedidos.getValue(Pedido.class);
                        if (pedido.getEstado().toString().equals("activo")) {
                            lstPedidos.add(pedido);
                        }
                    }
                } else {
                    tvOrdenes.setText("Historial de ordenes");
                    for (DataSnapshot pedidos : dataSnapshot.getChildren()) {
                        Pedido pedido = pedidos.getValue(Pedido.class);
                        if (pedido.getEstado().toString().equals("entregado")) {
                            lstPedidos.add(pedido);
                        }
                    }
                }

                if(lstPedidos.isEmpty()){
                    Toast.makeText(getContext(), "No existen ordenes", Toast.LENGTH_SHORT).show();
                } else {
                    AdaptadorOrdenes adapter = new AdaptadorOrdenes(lstPedidos);
                    recyclerPedidos.setAdapter(adapter);
                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Pedido p = lstPedidos.get(recyclerPedidos.getChildAdapterPosition(view));
                            Bundle bundle = new Bundle();
                            bundle.putString("IdPedido", p.getId());
                            Fragment fragment = new OrderFragment();
                            fragment.setArguments(bundle);
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return lstPedidos;
    }


}
