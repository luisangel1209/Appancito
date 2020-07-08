package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;

import java.util.ArrayList;

public class ConfirmarPedido2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido2);

    }

    public void Regresar(View view){
        Intent regresar = new Intent(ConfirmarPedido2.this, SolicitarPedido.class);
        startActivity(regresar);
    }

    public void DE(View view){
        Intent datose = new Intent(ConfirmarPedido2.this, DatosEntrega.class);
        startActivity(datose);
    }

}
