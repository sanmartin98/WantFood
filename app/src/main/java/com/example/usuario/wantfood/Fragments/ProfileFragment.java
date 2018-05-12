package com.example.usuario.wantfood.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.wantfood.Clases.Mensajero;
import com.example.usuario.wantfood.ManejoUser;
import com.example.usuario.wantfood.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private TextView tvName, tvEmail, tvCedula, tvPlaca;
    private ManejoUser mn = new ManejoUser();
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        mn.inicializatedFireBase();
        init();

        return view;
    }

    private void selectData(){
        mn.databaseReference.child("Mensajeros").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot mensajeros : dataSnapshot.getChildren()){
                    Mensajero mensajero = mensajeros.getValue(Mensajero.class);
                    if(mn.firebaseUser.getEmail().equals(mensajero.getEmail())){
                        tvName.setText(mensajero.getNombre());
                        tvEmail.setText(mensajero.getEmail());
                        tvCedula.setText(mensajero.getCedula());
                        tvPlaca.setText(mensajero.getPlaca());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void init(){
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvCedula = (TextView) view.findViewById(R.id.tvCc);
        tvPlaca = (TextView) view.findViewById(R.id.tvPlaca);
        selectData();
    }

}
