package com.example.appancito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ConfirmarPedido extends AppCompatActivity {
    private DatabaseReference DBPanes;
    TextView bolillo;
    TextView concha;
    TextView cuerno;
    TextView oreja;

    TextView TotalBol;
    TextView TotalCon;
    TextView TotalCue;
    TextView TotalOre;

    TextView totalpagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);
        Bolillo();
    }

    public void Bolillo(){
        //Dato Bolillo
        bolillo = (TextView)findViewById(R.id.Bolillo);
        Bundle datos = this.getIntent().getExtras();
        final String numbolillo = datos.getString("NumeroBolillo");
        bolillo.setText(numbolillo);
        //Total Bolillo
        numbolillo.trim();
        final int nb = Integer.parseInt(numbolillo);

        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Bolillo");

        TotalBol = (TextView)findViewById(R.id.TotalBolillo);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        String precio = panes.child("Precio").getValue().toString();
                        precio.trim();
                        int precio1 = Integer.parseInt(precio);
                        int totalb = nb*precio1;
                        TotalBol.setText("$"+totalb);
                        Concha(totalb);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Concha(final int totalb){
        //Dato Concha
        concha = (TextView)findViewById(R.id.Concha);
        Bundle datos = this.getIntent().getExtras();
        String numconcha = datos.getString("NumeroConcha");
        concha.setText(numconcha);
        //Total Concha
        numconcha.trim();
        final int nb = Integer.parseInt(numconcha);

        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Concha");

        TotalCon = (TextView)findViewById(R.id.TotalConcha);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        String precio = panes.child("Precio").getValue().toString();
                        precio.trim();
                        int precio1 = Integer.parseInt(precio);
                        int totalco = nb*precio1;
                        TotalCon.setText("$"+totalco);
                        int to = totalb+totalco;
                        Cuerno(to);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Cuerno(final int to){
        //Dato Cuerno
        cuerno = (TextView)findViewById(R.id.Cuerno);
        Bundle datos = this.getIntent().getExtras();
        String numcuerno = datos.getString("NumeroCuerno");
        cuerno.setText(numcuerno);
        //Total Cuerno
        numcuerno.trim();
        final int nb = Integer.parseInt(numcuerno);

        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Cuernito");

        TotalCue = (TextView)findViewById(R.id.TotalCuerno);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        String precio = panes.child("Precio").getValue().toString();
                        precio.trim();
                        int precio1 = Integer.parseInt(precio);
                        int totalcu = nb*precio1;
                        TotalCue.setText("$"+totalcu);
                        int tot = to+totalcu;
                        Oreja(tot);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Oreja(final int tot){
        //Dato Oreja
        oreja = (TextView)findViewById(R.id.Oreja);
        Bundle datos = this.getIntent().getExtras();
        String numoreja = datos.getString("NumeroOreja");
        oreja.setText(numoreja);
        //Total Oreja
        numoreja.trim();
        final int nb = Integer.parseInt(numoreja);

        DBPanes = FirebaseDatabase.getInstance().getReference();
        Query query = DBPanes.child("Panes").orderByChild("Pan").equalTo("Oreja");

        TotalOre = (TextView)findViewById(R.id.TotalOreja);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot panes : dataSnapshot.getChildren()){
                        String precio = panes.child("Precio").getValue().toString();
                        precio.trim();
                        int precio1 = Integer.parseInt(precio);
                        int totalo = nb*precio1;
                        TotalOre.setText("$"+totalo);

                        totalpagar = (TextView)findViewById(R.id.TotalPagar);
                        int total = tot+totalo;
                        totalpagar.setText("$"+total);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void Regresar(View view){
        Intent regresar = new Intent(ConfirmarPedido.this, PedidoPequenio.class);
        startActivity(regresar);
    }

    public void Datosentrega(View view){
        Intent intent = new Intent(ConfirmarPedido.this, DatosEntrega.class);
        bolillo = findViewById(R.id.Bolillo);
        concha = findViewById(R.id.Concha);
        cuerno = findViewById(R.id.Cuerno);
        oreja = findViewById(R.id.Oreja);
        totalpagar = findViewById(R.id.TotalPagar);
        intent.putExtra("NumeroBolillo", bolillo.getText().toString());
        intent.putExtra("NumeroConcha", concha.getText().toString());
        intent.putExtra("NumeroCuerno", cuerno.getText().toString());
        intent.putExtra("NumeroOreja", oreja.getText().toString());
        intent.putExtra("TotalPagar", totalpagar.getText().toString());
        startActivity(intent);
    }

}
