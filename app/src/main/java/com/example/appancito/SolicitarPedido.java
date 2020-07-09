package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.appancito.Model.ItemList;
import com.example.appancito.adaptador.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SolicitarPedido extends AppCompatActivity  {
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_pedido);

        initViews();
        initValues();
    }
    public void Regresar(View view){
        Intent regresar = new Intent(SolicitarPedido.this, Principal.class);
        startActivity(regresar);
    }

    public void Confi(View view){


        Intent de = new Intent(SolicitarPedido.this, ConfirmarPedido2.class);
        startActivity(de);
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items);
        rvLista.setAdapter(adapter);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Bolillo", "Escribe las piezas a Solicitar", "22",R.drawable.bolillo));
        itemLists.add(new ItemList("Concha", "Escribe las piezas a Solicitar", "43",R.drawable.concha));
        itemLists.add(new ItemList("Oreja", "Escribe las piezas a Solicitar","34", R.drawable.orejas));
        itemLists.add(new ItemList("Cuernito", "Escribe las piezas a Solicitar", "12",R.drawable.cuernitos));
        return itemLists;
    }

}