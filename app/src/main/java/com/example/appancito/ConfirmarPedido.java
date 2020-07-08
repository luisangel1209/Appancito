package com.example.appancito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.appancito.Model.ItemList;

import java.util.ArrayList;

public class ConfirmarPedido extends AppCompatActivity {
    private ImageView imgItemDetail;
    private TextView numero;
    private TextView tvDescripcionDetail;
    private ItemList itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);
        numero = (TextView)findViewById(R.id.textnum);
        Bundle bundle = getIntent().getExtras();

        String dato = bundle.getString("Numero").toString();
        numero.setText(dato);
    }

    /*private void initViews() {
        imgItemDetail = findViewById(R.id.imgItemDetail);
        tvTituloDetail = findViewById(R.id.tvTituloDetail);
        tvDescripcionDetail = findViewById(R.id.tvDescripcionDetail);
    }

    private void initValues(){
        itemDetail = (ItemList) getIntent().getExtras().getSerializable("itemDetail");

        imgItemDetail.setImageResource(itemDetail.getImgResource());
        tvTituloDetail.setText(itemDetail.getTitulo());
        tvDescripcionDetail.setText(itemDetail.getDescripcion());
    }*/

    public void Regresar(View view){
        Intent regresar = new Intent(ConfirmarPedido.this, SolicitarPedido.class);
        startActivity(regresar);
    }

    public void Datosentrega(View view){
        Intent de = new Intent(ConfirmarPedido.this, DatosEntrega.class);
        startActivity(de);
    }

}
