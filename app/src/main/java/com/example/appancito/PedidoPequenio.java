package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PedidoPequenio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_pequenio);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(PedidoPequenio.this, Login.class);
        startActivity(regresar);
    }

}
