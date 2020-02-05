package com.example.retocomercial;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class Evento extends AppCompatActivity implements View.OnClickListener {
    private EditText nombreEvento;
    private EditText descripcion;
    private EditText localizacion;
    private EditText anio;
    private EditText mes;
    private EditText dia;
    private Button guardar;
    private Calendar noseque;
    private Date nosecuantos;
    private TextView diaEleg;
    EditText editHora;
    Button botonHora;
    TextView text3;
    EditText nom;

    private int hour, minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_evento);


        descripcion = findViewById(R.id.txtDescripcion);
        diaEleg = findViewById(R.id.diaElegido);
        guardar = findViewById(R.id.btnGuardar);

        editHora = findViewById(R.id.editHora);
        botonHora = findViewById(R.id.btnHora);

        nom = findViewById(R.id.txtNombre);

        //Decir la fecha en textView
        Bundle bun = getIntent().getExtras();
        int dia = 0, mes = 0, ano = 0;
        dia = bun.getInt("dia");
        mes = bun.getInt("mes");
        ano = bun.getInt("ano");

        final String dia_mes_ano = dia + "/" + (mes + 1) + "/" + ano;
        diaEleg.setText("Añadir visita al día: " + dia_mes_ano);

        //TimePicker (introducir la hora)

        botonHora.setOnClickListener(this);

        //Boton Guardar
        guardar.setOnClickListener(new View.OnClickListener() {
            private Activity Evento;

            @Override
            public void onClick(View v) {
                if (editHora.length() > 0 && nom.length() > 0 && descripcion.length() > 0) {
                    //devolverRespuesta(dia_mes_ano+" - "+nom.getText().toString()+" - "+descripcion.getText().toString()+" - "+editHora.getText().toString());
                    devolverRespuesta2(nom.getText().toString(), descripcion.getText().toString(), editHora.getText().toString(), dia_mes_ano);
                    finish();
                } else if (editHora.length() > 0 && nom.length() > 0) {
                    //devolverRespuesta(nom.getText().toString()+" - "+editHora.getText().toString());
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Le falta algun dato por rellenar", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    /*protected void devolverRespuesta(String respuesta){
        Log.e("de vuelta",respuesta);
        Intent devolver=new Intent();
        devolver.putExtra("nuevo",respuesta);
        setResult(RESULT_OK,devolver);
    }*/
    protected void devolverRespuesta2(String nom, String desc, String hora, String fecha) {
        Intent devolver = new Intent();
        Bundle bun = new Bundle();
        bun.putString("nom", nom);
        bun.putString("desc", desc);
        bun.putString("hora", hora);
        bun.putString("fecha", fecha);
        devolver.putExtras(bun);
        setResult(RESULT_OK, devolver);
    }

    @Override
    public void onClick(View v) {
        if (v == botonHora) {
            final Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minutes = c.get(Calendar.MINUTE);

            TimePickerDialog hora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    editHora.setText(hourOfDay + ":" + minute);
                }
            }, hour, minutes, false);
            hora.show();




        }
    }

}