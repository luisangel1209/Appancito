package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class DatosEntrega extends AppCompatActivity{

    Spinner horas;
    Button fecha;
    TextView fechat;
    EditText nombre;
    private int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_entrega);
        horas = (Spinner)findViewById(R.id.spHoraEntrega);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Horas, android.R.layout.simple_spinner_item);
        horas.setAdapter(adapter);

        fechat = (TextView) findViewById(R.id.fecha);
        Calendar c = Calendar.getInstance();
        String Date = c.get(Calendar.DAY_OF_MONTH)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.YEAR);
        fechat.setText(Date);
        /*fecha = (Button)findViewById(R.id.Seleccionarfecha);
        fechat = (EditText)findViewById(R.id.fecha);
        fecha.setOnClickListener(this);*/
    }

    public void Regresar(View view){
        Intent regresar = new Intent(DatosEntrega.this, ConfirmarPedido.class);
        startActivity(regresar);
    }



    public void FormaPago(View view){
        Intent intent = new Intent(DatosEntrega.this, FormaPago.class);
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
        fechat = findViewById(R.id.fecha);
        Bundle fecha = this.getIntent().getExtras();
        intent.putExtra("Fecha", fechat.getText().toString());
        //Nombre
        nombre = findViewById(R.id.TxtNombreDatosEntrega);
        intent.putExtra("Nombre", nombre.getText().toString());
        //Hora
        String item = (String) horas.getSelectedItem();
        intent.putExtra("Horas", item);
        startActivity(intent);
    }

    /*@Override
    implements View.OnClickListener
    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fechat.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            }
        }, ano, mes,dia);
        datePickerDialog.show();
    }*/
}
