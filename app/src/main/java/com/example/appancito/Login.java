package com.example.appancito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText textnomco;
    private EditText textcontra;
    private Button login;
    private String nombrecon = "";
    private String contra = "";
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textnomco = (EditText) findViewById(R.id.editTextUsuario);
        textcontra = (EditText) findViewById(R.id.editTextContra);
        login = (Button) findViewById(R.id.BotonEntrar);
        Auth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombrecon = textnomco.getText().toString();
                contra = textcontra.getText().toString();
                if(!nombrecon.isEmpty() && !contra.isEmpty()){
                    LoginUser();
                }else{
                    Toast.makeText(Login.this, "Debes completar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void LoginUser(){
        Auth.signInWithEmailAndPassword(nombrecon, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(Login.this, Principal.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "No se pudo inicar sesion, comprueba los datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Registro(View view){
        Intent registro = new Intent(Login.this, Registro.class);
        startActivity(registro);
    }
    public void RecuperarContra(View view){
        Intent recuperarcontra = new Intent(Login.this, RecuperarContra.class);
        startActivity(recuperarcontra);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(Auth.getCurrentUser() != null){
            startActivity(new Intent(Login.this, Principal.class));
            finish();
        }
    }
}
