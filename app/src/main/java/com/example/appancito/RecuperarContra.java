package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarContra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(RecuperarContra.this, Login.class);
        startActivity(regresar);
    }
}
