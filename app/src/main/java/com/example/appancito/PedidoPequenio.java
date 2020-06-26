package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appancito.R;
import com.example.appancito.Model.ItemList;
import com.example.appancito.adaptador.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PedidoPequenio extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick {
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_pequenio);

        initViews();
        initValues();
    }
    public void Regresar(View view){
        Intent regresar = new Intent(PedidoPequenio.this, Principal.class);
        startActivity(regresar);
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Bolillo", "Escribe las piezas a Solicitar", R.drawable.bolillo));
        itemLists.add(new ItemList("Concha", "Escribe las piezas a Solicitar", R.drawable.concha));
        itemLists.add(new ItemList("Oreja", "Escribe las piezas a Solicitar", R.drawable.orejas));
        itemLists.add(new ItemList("Cuernito", "Escribe las piezas a Solicitar", R.drawable.cuernitos));
        return itemLists;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }
}