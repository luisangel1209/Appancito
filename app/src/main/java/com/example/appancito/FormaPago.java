package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormaPago extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pago);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(FormaPago.this, DatosEntrega.class);
        startActivity(regresar);
    }

    public void Home(View view){
        Intent home = new Intent(FormaPago.this, Principal.class);
        startActivity(home);
    }
    public void Imagen(View view){
        Intent imagen = new Intent(FormaPago.this, SubirImagen.class);
        startActivity(imagen);
    }
}
