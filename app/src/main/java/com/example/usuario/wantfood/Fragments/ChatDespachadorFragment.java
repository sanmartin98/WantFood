package com.example.usuario.wantfood.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.usuario.wantfood.AdapterMensajes;
import com.example.usuario.wantfood.MensajeEnviar;
import com.example.usuario.wantfood.MensajeRecibir;
import com.example.usuario.wantfood.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatDespachadorFragment extends Fragment {


    public ChatDespachadorFragment() {
        // Required empty public constructor
    }




    private TextView tvUserName;
    private ImageButton imageButtonEnviar;
    private RecyclerView rvMensajes;
    private CircleImageView ciFotoPerfil;
    private EditText txtMensaje;
    private View view;
    private String idPedido;

    private AdapterMensajes adapterMensajes;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chat_despachador, container, false);
        if(getArguments()!= null){
            idPedido = getArguments().getString("id");
        }
        iniciar();
        tvUserName.setText("Despachador");

        adapterMensajes = new AdapterMensajes(getActivity());
        LinearLayoutManager l = new LinearLayoutManager(getContext());
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapterMensajes);


        imageButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child("Pedidos").child(idPedido).child("ChatDespachador").push().setValue(new MensajeEnviar(txtMensaje.getText().toString(),ProfileFragment.m1));

                txtMensaje.setText("");
            }
        });

        adapterMensajes.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollBar();
            }
        });

        databaseReference.child("Pedidos").child(idPedido).child("ChatDespachador").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MensajeRecibir m = dataSnapshot.getValue(MensajeRecibir.class);
                adapterMensajes.addMensaje(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    private void setScrollBar(){
        rvMensajes.scrollToPosition(adapterMensajes.getItemCount()-1);
    }




    public void iniciar(){
        tvUserName = (TextView) view.findViewById(R.id.tvUserName);
        imageButtonEnviar = (ImageButton) view.findViewById(R.id.imgBtnEnviar);
        rvMensajes = (RecyclerView) view.findViewById(R.id.rvMensajes);
        ciFotoPerfil = (CircleImageView) view.findViewById(R.id.ciFotoPerfil);
        txtMensaje = (EditText) view.findViewById(R.id.txtMensaje);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();



    }

}
