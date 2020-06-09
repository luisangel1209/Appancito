package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DatosEntrega extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_entrega);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(DatosEntrega.this, ConfirmarPedido.class);
        startActivity(regresar);
    }

    public void FormaPago(View view){
        Intent formapago = new Intent(DatosEntrega.this, FormaPago.class);
        startActivity(formapago);
    }
}
