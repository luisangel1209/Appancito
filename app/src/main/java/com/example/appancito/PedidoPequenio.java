package com.example.appancito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class PedidoPequenio extends AppCompatActivity {

    private DatabaseReference DBPanes;
    ListView listabolillo;
    ArrayList<String> listasstrbolillo;
    ArrayAdapter<String> adapterbolillo;

    ListView listaconcha;
    ArrayList<String> listasstrconcha;
    ArrayAdapter<String> adapterconcha;

    ListView listacuerno;
    ArrayList<String> listasstrcuerno;
    ArrayAdapter<String> adaptercuerno;

    ListView listaoreja;
    ArrayList<String> listasstroreja;
    ArrayAdapter<String> adapteroreja;

    EditText compBolillo;
    EditText compConcha;
    EditText compCuerno;
    EditText compOreja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_pequenio);
        Bolillo();
        Concha();
        Cuerno();
        Oreja();
    }

    public void Bolillo(){
        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Bolillo");

        listabolillo = (ListView)findViewById(R.id.listabolillo);
        listasstrbolillo = new ArrayList<String>(0);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        int piezas = panes.child("Piezas").getValue().hashCode();
                        int precio = panes.child("Precio").getValue().hashCode();
                        listasstrbolillo.add(piezas+" piezas disponibles      $"+precio+" por pieza");
                        adapterbolillo = new ArrayAdapter<String>(PedidoPequenio.this, android.R.layout.simple_list_item_1, listasstrbolillo);
                        listabolillo.setAdapter(adapterbolillo);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Concha(){
        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Concha");

        listaconcha = (ListView)findViewById(R.id.listaconcha);
        listasstrconcha = new ArrayList<String>(0);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        int piezas = panes.child("Piezas").getValue().hashCode();
                        int precio = panes.child("Precio").getValue().hashCode();
                        listasstrconcha.add(piezas+" piezas disponibles      $"+precio+" por pieza");
                        adapterconcha = new ArrayAdapter<String>(PedidoPequenio.this, android.R.layout.simple_list_item_1, listasstrconcha);
                        listaconcha.setAdapter(adapterconcha);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Cuerno(){
        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Cuernito");

        listacuerno = (ListView)findViewById(R.id.listacuernos);
        listasstrcuerno = new ArrayList<String>(0);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        int piezas = panes.child("Piezas").getValue().hashCode();
                        int precio = panes.child("Precio").getValue().hashCode();
                        listasstrcuerno.add(piezas+" piezas disponibles      $"+precio+" por pieza");
                        adaptercuerno = new ArrayAdapter<String>(PedidoPequenio.this, android.R.layout.simple_list_item_1, listasstrcuerno);
                        listacuerno.setAdapter(adaptercuerno);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Oreja(){
        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Oreja");

        listaoreja = (ListView)findViewById(R.id.listaorejas);
        listasstroreja = new ArrayList<String>(0);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        int piezas = panes.child("Piezas").getValue().hashCode();
                        int precio = panes.child("Precio").getValue().hashCode();
                        listasstroreja.add(piezas+" piezas disponibles      $"+precio+" por pieza");
                        adapteroreja = new ArrayAdapter<String>(PedidoPequenio.this, android.R.layout.simple_list_item_1, listasstroreja);
                        listaoreja.setAdapter(adapteroreja);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Regresar(View view) {
        Intent regresar = new Intent(PedidoPequenio.this, Principal.class);
        startActivity(regresar);
    }

    public void Confi(View view) {
        Intent intent = new Intent(PedidoPequenio.this, ConfirmarPedido.class);
        compBolillo = findViewById(R.id.editTextBolillo);
        compConcha = findViewById(R.id.editTextConcha);
        compCuerno = findViewById(R.id.editTextCuernos);
        compOreja = findViewById(R.id.editTextOrejas);
        intent.putExtra("NumeroBolillo", compBolillo.getText().toString());
        intent.putExtra("NumeroConcha", compConcha.getText().toString());
        intent.putExtra("NumeroCuerno", compCuerno.getText().toString());
        intent.putExtra("NumeroOreja", compOreja.getText().toString());
        startActivity(intent);
    }
}
