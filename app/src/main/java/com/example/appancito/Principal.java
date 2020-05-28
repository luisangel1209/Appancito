package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Principal extends AppCompatActivity {

    private ImageView cerrarsesion;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        cerrarsesion = (ImageView) findViewById(R.id.cerrarsesion);
        Auth = FirebaseAuth.getInstance();
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.signOut();
                startActivity(new Intent(Principal.this, Login.class));
                finish();
            }
        });
    }

    public void Ayuda(View view){
        Intent ayuda = new Intent(Principal.this, Ayuda.class);
        startActivity(ayuda);
    }
    public void Contacto(View view){
        Intent contacto = new Intent(Principal.this, Ayuda.class);
        startActivity(contacto);
    }
    public void Pedidos(View view){
        Intent pedidos = new Intent(Principal.this, Ayuda.class);
        startActivity(pedidos);
    }
}

