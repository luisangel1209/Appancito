package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Calendar;

public class DatosEntrega extends AppCompatActivity implements View.OnClickListener {

    Spinner horas;
    Button fecha;
    EditText fechat;
    private int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_entrega);

        horas = (Spinner)findViewById(R.id.spHoraEntrega);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Horas, android.R.layout.simple_spinner_item);
        horas.setAdapter(adapter);

        fecha = (Button)findViewById(R.id.Seleccionarfecha);
        fechat = (EditText)findViewById(R.id.fecha);
        fecha.setOnClickListener(this);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(DatosEntrega.this, ConfirmarPedido.class);
        startActivity(regresar);
    }

    public void FormaPago(View view){
        Intent formapago = new Intent(DatosEntrega.this, FormaPago.class);
        startActivity(formapago);
    }

    @Override
    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fechat.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, dia, mes,ano);
        datePickerDialog.show();
    }
}
