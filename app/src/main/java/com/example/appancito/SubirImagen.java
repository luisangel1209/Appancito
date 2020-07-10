package com.example.appancito;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.content.FileProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.net.URI;

public class SubirImagen extends AppCompatActivity {
    private DatabaseReference DBPanes;
    private final String CARPETA_RAIZ="misImagenesPrueba/";
    private final String RUTA_IMAGEN=CARPETA_RAIZ+"misFotos";
    final int COD_SELECCIONA=10;
    final int COD_FOTO=20;

    ImageView imagen;
    String path;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_imagen);
        imagen = (ImageView)findViewById(R.id.imgcarga);
    }

    public void onClick(View view){
        cargarImagen();
    }

    public void onClick2(View view){
        registrarCompra();
    }

    private void cargarImagen() {
        final CharSequence[] opciones = {"Tomar Foto", "Cargar Imagen", "Cancelar"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(SubirImagen.this);
        alertOpciones.setTitle("Seleccione una opción:");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(opciones[i].equals("Tomar Foto")){
                    tomarFoto();
                }else{
                    if(opciones[i].equals("Cargar Imagen")){
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicación"), COD_SELECCIONA);
                    }else{
                        dialog.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();
    }

    private void tomarFoto() {
        File fileImagen = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        boolean IsCreada = fileImagen.exists();
        String nombreImagen = "";
        if(IsCreada == false){
            IsCreada = fileImagen.mkdirs();
        }
        if(IsCreada == true){
            nombreImagen = (System.currentTimeMillis()/1000)+".jpg";
        }
        path = Environment.getExternalStorageDirectory()+File.separator+RUTA_IMAGEN+File.separator+nombreImagen;
        File imagen = new File(path);

        Intent intent = null;
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            String authorities = getApplicationContext().getPackageName()+".provider";
            Uri imageUri = FileProvider.getUriForFile(this, authorities, imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else{
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent, COD_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri mipath = data.getData();
                    imagen.setImageURI(mipath);
                    break;
                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            Log.i("Ruta de almacenamiento", "Path: "+path);
                        }
                    });
                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);
                    break;
            }
        }
    }

    public void Regresar(View view){
        Intent regresar = new Intent(SubirImagen.this, FormaPago.class);
        startActivity(regresar);
    }

    public void Home(View view){
        Intent home = new Intent(SubirImagen.this, Principal.class);
        startActivity(home);
    }

    public void registrarCompra(){
        //Bolillo
        Bundle datosb = this.getIntent().getExtras();
        final String numbolillo = datosb.getString("NumeroBolillo");
        int bolillo = Integer.parseInt(numbolillo);
        //Concha
        Bundle datosco = this.getIntent().getExtras();
        final String numconcha = datosco.getString("NumeroConcha");
        int concha = Integer.parseInt(numconcha);
        //Cuerno
        Bundle datoscu = this.getIntent().getExtras();
        final String numerocuero = datoscu.getString("NumeroCuerno");
        int cuerno = Integer.parseInt(numerocuero);
        //Oreja
        Bundle datoso = this.getIntent().getExtras();
        final String numerooreja = datoso.getString("NumeroOreja");
        int oreja = Integer.parseInt(numerooreja);
        //Total
        Bundle totalp = this.getIntent().getExtras();
        final String totalpagar = totalp.getString("TotalPagar");
        String total = totalpagar;
        //Fecha
        Bundle fecha = this.getIntent().getExtras();
        final String fech = fecha.getString("Fecha");
        String fc = fech;
        //Nombre
        Bundle nom = this.getIntent().getExtras();
        final String nombre = nom.getString("Nombre");
        String nomb = nombre;
        //Hora
        Bundle hora = this.getIntent().getExtras();
        final String hor = hora.getString("Horas");
        String h = hor;
        DBPanes = FirebaseDatabase.getInstance().getReference("Compras");
        String id = DBPanes.push().getKey();
        Carrito peli = new Carrito(id, bolillo, concha, cuerno, oreja, total, fc, h, nomb);
        DBPanes.child(id).setValue(peli);
        Toast.makeText(this, "Compra Realizada", Toast.LENGTH_LONG).show();
    }

}
