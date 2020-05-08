package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Registro(View view){
        Intent registro = new Intent(Login.this, Registro.class);
        startActivity(registro);
    }
    public void RecuperarContra(View view){
        Intent recuperarcontra = new Intent(Login.this, RecuperarContra.class);
        startActivity(recuperarcontra);
    }
    public void Principal(View view){
        Intent principal = new Intent(Login.this, Principal.class);
        startActivity(principal);
    }

}
