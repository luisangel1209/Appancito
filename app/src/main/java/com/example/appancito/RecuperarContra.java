package com.example.appancito;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseAuth;

public class RecuperarContra extends AppCompatActivity {

    private EditText textcorreo;
    private Button enviar;
    private String correo = "";
    private FirebaseAuth Auth;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);

        textcorreo = (EditText) findViewById(R.id.editTextCorreo);
        enviar = (Button) findViewById(R.id.buttonEnviar);
        Auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = textcorreo.getText().toString();
                if(!correo.isEmpty()){
                    dialog.setMessage("Espere un momento...");
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    enviarContra();
                }else{
                    Toast.makeText(RecuperarContra.this, "Debes ingresar tu correo electronico", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void enviarContra(){
        Auth.setLanguageCode("es");
        Auth.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RecuperarContra.this, "Se ha enviado un correo para restablecer tu contraseña", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RecuperarContra.this, "No se pudo enviar el correo para restablecer tu contraseña", Toast.LENGTH_LONG).show();
                }
                dialog.dismiss();
            }
        });
    }

    public void Regresar(View view){
        Intent regresar = new Intent(RecuperarContra.this, Login.class);
        startActivity(regresar);
    }
}
