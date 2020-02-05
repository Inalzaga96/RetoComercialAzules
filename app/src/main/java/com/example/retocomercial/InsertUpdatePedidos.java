package com.example.retocomercial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InsertUpdatePedidos extends AppCompatActivity {
    private EditText fecha;
    private Spinner articulo;
    private EditText cantidad;
    private EditText descuento;
    private Button anadir;
    private Button borrar;
    private Button volver;
    private ArrayList<String> articulos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertupdatepedido);
        fecha = findViewById(R.id.txtFecha);
        articulo = findViewById(R.id.spnArticulo);
        cantidad = findViewById(R.id.txtCantidad);
        descuento = findViewById(R.id.txtDescuento);
        anadir=findViewById(R.id.btnAnadir);
        borrar=findViewById(R.id.btnBorrar);
        volver=findViewById(R.id.btnVolver);
        articulos=new ArrayList<>();

        volver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vuelve(null,1234);
            }
        });
        anadir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vuelve(null,1234);
            }
        });
        borrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                borra(null,1234);
            }
        });
    }
    private void vuelve(View view, int num){
        Intent intent = new Intent(this, Pedidos.class);
        setResult(RESULT_OK,intent);
        finish();
    }
    private void aniade(View view, int num){

    }
    private void borra(View view, int num){

    }
}