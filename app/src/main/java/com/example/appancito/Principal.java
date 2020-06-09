package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void PP(View view){
        Intent pp = new Intent(Principal.this, PedidoPequenio.class);
        startActivity(pp);
    }

    public void PG(View view){
        Intent pg = new Intent(Principal.this, SolicitarPedido.class);
        startActivity(pg);
    }

    public void Ayuda(View view){
        Intent ayuda = new Intent(Principal.this, Ayuda.class);
        startActivity(ayuda);
    }
    public void Contacto(View view){
        Intent contacto = new Intent(Principal.this, Contacto.class);
        startActivity(contacto);
    }
    public void Pedidos(View view){
        Intent pedidos = new Intent(Principal.this, VerPedidos.class);
        startActivity(pedidos);
    }
}

