package com.example.usuario.wantfood;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.usuario.wantfood.Activitys.Activity_Principal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Usuario on 11/05/2018.
 */

public class ManejoUser {

    public DatabaseReference databaseReference;
    public FirebaseAuth firebaseAuth;
    public FirebaseDatabase firebaseDatabase;
    public FirebaseUser firebaseUser;

    public ManejoUser(){

    }

    public void inicializatedFireBase(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        databaseReference = firebaseDatabase.getReference();
    }

    public void logIn(String email, String pass, final Context context){
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseUser = firebaseAuth.getCurrentUser();
                    Toast.makeText(context, "Log succes", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, Activity_Principal.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context, "Por favor verifique su usuario y contraseña", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
