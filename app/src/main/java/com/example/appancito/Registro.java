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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private EditText TextNombre;
    private EditText TextApe;
    private EditText TextContra;
    private EditText TextTele;
    private Button BtnRegistro;

    //variables datos registro
    private String nombre = "";
    private String apellido = "";
    private String contraseña = "";
    private String telefono = "";
    FirebaseAuth Auth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference db = database.getReference();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        TextNombre = (EditText) findViewById(R.id.editTextNombre);
        TextApe = (EditText) findViewById(R.id.editTextApellido);
        TextContra = (EditText) findViewById(R.id.editTextContra);
        TextTele = (EditText) findViewById(R.id.editTextCorreo);
        BtnRegistro = (Button) findViewById(R.id.BotonRegistrarse);
        Auth = FirebaseAuth.getInstance();

        BtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = TextNombre.getText().toString();
                apellido = TextApe.getText().toString();
                contraseña = TextContra.getText().toString();
                telefono = TextTele.getText().toString();
                if(!nombre.isEmpty() && !apellido.isEmpty() && !contraseña.isEmpty() & !telefono.isEmpty() ){
                    if(contraseña.length() >= 6){
                        registrarusuario();
                    }else{
                        Toast.makeText(Registro.this, "La contraseña debe contener al menos 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Registro.this, "Debes completar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void registrarusuario(){
        Auth.createUserWithEmailAndPassword(telefono, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>(); //Mapa de valores
                    String nombreCom = ""+nombre +" "+apellido;
                    map.put("Nombre", nombreCom);
                    map.put("Contraseña", contraseña);
                    map.put("Correo", telefono);
                    String id = Auth.getCurrentUser().getUid();
                    db.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Toast.makeText(Registro.this, "Usuario creado con exito", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(Registro.this, "No se pudieron crear los datos", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }else{
                    Toast.makeText(Registro.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Regresar(View view){
        Intent regresar = new Intent(Registro.this, Login.class);
        startActivity(regresar);
    }
}
