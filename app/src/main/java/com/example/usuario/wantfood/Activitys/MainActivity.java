package com.example.usuario.wantfood.Activitys;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.wantfood.Activitys.Activity_Principal;
import com.example.usuario.wantfood.ManejoUser;
import com.example.usuario.wantfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtEmail, txtPassword;
    private Button btnIngresar;
    private ManejoUser mn = new ManejoUser();

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        verificaSignIn();
    }



    private void init(){
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        mn.inicializatedFireBase();
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int vista = view.getId();
        switch (vista){
            case R.id.btnIngresar: {
                if(!txtEmail.getText().toString().equals("") || !txtPassword.getText().toString().equals("")){
                    mn.logIn(txtEmail.getText().toString(), txtPassword.getText().toString(), MainActivity.this);
                } else Toast.makeText(getApplicationContext(), "Por favor ingrese usuario y contraseña", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void verificaSignIn(){
        if(mn.firebaseAuth.getCurrentUser() != null){
            mn.firebaseUser = mn.firebaseAuth.getCurrentUser();
            Toast.makeText(getApplicationContext(), "Usuario iniciado con email: " + mn.firebaseUser.getEmail(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), Activity_Principal.class));
        }
    }

}
