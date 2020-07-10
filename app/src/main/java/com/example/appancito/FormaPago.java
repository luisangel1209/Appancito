package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormaPago extends AppCompatActivity {
    TextView bo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pago);
        bo = (TextView)findViewById(R.id.textbo);
        //Dato Pagar
        Bundle datos = this.getIntent().getExtras();
        final String numbolillo = datos.getString("TotalPagar");
        bo.setText(numbolillo);
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
        Intent intent = new Intent(FormaPago.this, SubirImagen.class);
        //Bolillo
        Bundle datosb = this.getIntent().getExtras();
        final String numbolillo = datosb.getString("NumeroBolillo");
        intent.putExtra("NumeroBolillo", numbolillo.toString());
        //Concha
        Bundle datosco = this.getIntent().getExtras();
        final String numconcha = datosco.getString("NumeroConcha");
        intent.putExtra("NumeroConcha", numconcha.toString());
        //Cuerno
        Bundle datoscu = this.getIntent().getExtras();
        final String numerocuero = datoscu.getString("NumeroCuerno");
        intent.putExtra("NumeroCuerno", numerocuero.toString());
        //Oreja
        Bundle datoso = this.getIntent().getExtras();
        final String numerooreja = datoso.getString("NumeroOreja");
        intent.putExtra("NumeroOreja", numerooreja.toString());
        //Total
        Bundle totalp = this.getIntent().getExtras();
        final String totalpagar = totalp.getString("TotalPagar");
        intent.putExtra("TotalPagar", totalpagar.toString());
        //Fecha
        Bundle fecha = this.getIntent().getExtras();
        final String fech = fecha.getString("Fecha");
        intent.putExtra("Fecha", fech.toString());
        //Nombre
        Bundle nom = this.getIntent().getExtras();
        final String nombre = nom.getString("Nombre");
        intent.putExtra("Nombre", nombre.toString());
        //Hora
        Bundle hora = this.getIntent().getExtras();
        final String hor = hora.getString("Horas");
        intent.putExtra("Horas", hor.toString());
        startActivity(intent);
    }
}
