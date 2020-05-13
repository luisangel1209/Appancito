package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void Ayuda(View view){
        Intent ayuda = new Intent(Principal.this, Ayuda.class);
        startActivity(ayuda);
    }
    public void Contacto(View view){
        Intent contacto = new Intent(Principal.this, Ayuda.class);
        startActivity(contacto);
    }
    public void Pedidos(View view){
        Intent pedidos = new Intent(Principal.this, Ayuda.class);
        startActivity(pedidos);
    }
}

