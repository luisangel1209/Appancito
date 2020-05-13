package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Ayuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(Ayuda.this, Principal.class);
        startActivity(regresar);
    }
}
