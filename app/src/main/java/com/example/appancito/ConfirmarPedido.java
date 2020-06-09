package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConfirmarPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(ConfirmarPedido.this, SolicitarPedido.class);
        startActivity(regresar);
    }

    public void DE(View view){
        Intent datose = new Intent(ConfirmarPedido.this, ConfirmarPedido.class);
        startActivity(datose);
    }

}
