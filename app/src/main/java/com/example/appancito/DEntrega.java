package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DEntrega extends AppCompatActivity{

    Spinner horas;
    EditText fechat;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_entrega);
        horas = (Spinner)findViewById(R.id.SpinnerEntrega);
        ArrayAdapter<CharSequence> d = ArrayAdapter.createFromResource(this, R.array.Hora, android.R.layout.simple_spinner_item);
        horas.setAdapter(d);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(DEntrega.this, ConfirmarPedido2.class);
        startActivity(regresar);
    }

    public void FormaPago(View view){
        Intent intent = new Intent(DEntrega.this, FormaPago.class);
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
        fechat = findViewById(R.id.fechaa);
        Bundle fecha = this.getIntent().getExtras();
        intent.putExtra("Fecha", fechat.getText().toString());
        //Nombre
        nombre = findViewById(R.id.TxtNombreDatosEntregaa);
        intent.putExtra("Nombre", nombre.getText().toString());
        //Hora
        String item = (String) horas.getSelectedItem();
        intent.putExtra("Horas", item);
        startActivity(intent);
    }
}
