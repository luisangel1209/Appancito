package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
    public void ayuda(View view){
        Intent principal = new Intent(Login.this, Ayuda.class);
        startActivity(principal);
    }
    public void Datos(View view){
        Intent principal = new Intent(Login.this, DatosEntrega.class);
        startActivity(principal);
    }
    public void forma(View view){
        Intent principal = new Intent(Login.this, FormaPago.class);
        startActivity(principal);
    }
}
