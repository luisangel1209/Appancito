package com.example.appancito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appancito.Model.ItemList;
import com.example.appancito.adaptador.RecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PedidoPequenio extends AppCompatActivity {
    TextView titBolillo;
    TextView desBolillo;
    TextView pieBolillo;
    TextView cosBolillo;
    EditText compBolillo;

    TextView titConcha;
    TextView desConcha;
    TextView pieConcha;
    TextView cosConcha;
    EditText compConcha;

    TextView titCuerno;
    TextView desCuerno;
    TextView pieCuerno;
    TextView cosCuerno;
    EditText compCuerno;

    TextView titOreja;
    TextView desOreja;
    TextView pieOreja;
    TextView cosOreja;
    EditText compOreja;

    EditText numero;
    Button bsiguiente;
    private DatabaseReference DBPanes;
    private List<Pan> panes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_pequenio);

        recuperarComponentes();
        //recuperValores();
        asignarValores();

    }

    public void Regresar(View view) {
        Intent regresar = new Intent(PedidoPequenio.this, Principal.class);
        startActivity(regresar);
    }

    public void Confi(View view) {
        Intent de = new Intent(PedidoPequenio.this, ConfirmarPedido2.class);
        generarCarrito();
        startActivity(de);
    }

    public void recuperarComponentes() {
        try {
            titBolillo = findViewById(R.id.tvBolillo);
            desBolillo = findViewById(R.id.tvDesBolillo);
            pieBolillo = findViewById(R.id.tvPieBolillo);
            cosBolillo = findViewById(R.id.tvCosBolillo);
            compBolillo = findViewById(R.id.etBolillo);

            titConcha = findViewById(R.id.tvCocha);
            desConcha = findViewById(R.id.tvDesConcha);
            pieConcha = findViewById(R.id.tvPieConcha);
            cosConcha = findViewById(R.id.tvCosConcha);
            compConcha = findViewById(R.id.etConcha);

            titCuerno = findViewById(R.id.tvCuerno);
            desCuerno = findViewById(R.id.tvDesCuerno);
            pieCuerno = findViewById(R.id.tvPieCuerno);
            cosCuerno = findViewById(R.id.tvCosCuerno);
            compCuerno = findViewById(R.id.etCuerno);

            titOreja = findViewById(R.id.tvOreja);
            desOreja = findViewById(R.id.tvDesOreja);
            pieOreja= findViewById(R.id.tvPieOreja);
            cosOreja = findViewById(R.id.tvcosOreja);
            compOreja = findViewById(R.id.etOreja);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recuperValores() {
        try {
            DBPanes = FirebaseDatabase.getInstance().getReference();
            Query query = DBPanes.child("Panes");
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        DataSnapshot pan = (DataSnapshot) dataSnapshot.getChildren();
                        /*
                        valBolillo = pan.child("Nombre").getValue().toString();

                        valDesBolillo = pan.child("Descripcion").getValue().toString();
                        valPieBolillo = pan.child("Piezas").getValue().toString();
                        valCosBolillo = pan.child("Costo").getValue().toString();
                        */
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void asignarValores() {
        try {
            titBolillo.setText("Bolillo");
            desBolillo.setText("Pan Salado");
            pieBolillo.setText("23");
            cosBolillo.setText("$1");

            titConcha.setText("Concha");
            desConcha.setText("El pan mas delicioso de mexico, la especialidad de la casa");
            pieConcha.setText("43");
            cosConcha.setText("$4");

            titCuerno.setText("Oreja");
            desCuerno.setText("El tradicional cuerno");
            pieCuerno.setText("41");
            cosCuerno.setText("$5");

            titOreja.setText("Oreja");
            desOreja.setText("Pan ojaldrado muy cruijiente");
            pieOreja.setText("32");
            cosOreja.setText("$6");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void generarCarrito(){
        Carrito.bolillos = Integer.parseInt(compBolillo.getText().toString());
        Carrito.conchas = Integer.parseInt(compConcha.getText().toString());
        Carrito.cuernos = Integer.parseInt(compCuerno.getText().toString());
        Carrito.orejas = Integer.parseInt(compOreja.getText().toString());
    }
}
