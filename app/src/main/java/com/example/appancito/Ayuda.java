package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Ayuda extends AppCompatActivity {

    private ImageView cerrarsesion;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        cerrarsesion = (ImageView) findViewById(R.id.cerrarsesion);
        Auth = FirebaseAuth.getInstance();
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.signOut();
                startActivity(new Intent(Ayuda.this, Login.class));
                finish();
            }
        });
    }

    public void Regresar(View view){
        Intent regresar = new Intent(Ayuda.this, Principal.class);
        startActivity(regresar);
    }
}
