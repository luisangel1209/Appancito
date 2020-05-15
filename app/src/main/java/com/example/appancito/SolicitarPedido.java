package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SolicitarPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_pedido);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(SolicitarPedido.this, Login.class);
        startActivity(regresar);
    }
}
