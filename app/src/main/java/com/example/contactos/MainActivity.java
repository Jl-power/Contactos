package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int dia,mes,año,sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar c = Calendar.getInstance();
    EditText nombre,fecha,tel,email,descrip;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        año = c.get(Calendar.YEAR);

        nombre = (EditText) findViewById(R.id.editTextTextPersonName);
        tel = (EditText) findViewById(R.id.editTextPhone);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        descrip = (EditText) findViewById(R.id.editTextTextMultiLine);
        fecha = (EditText) findViewById(R.id.editTextDate);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
            }
        });
        next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacto contacto = new Contacto(nombre.getText().toString(),fecha.getText().toString(),tel.getText().toString(),email.getText().toString(),descrip.getText().toString());

                Intent i = new Intent(MainActivity.this,Datos.class);
                i.putExtra("nombre",contacto.getNombre());
                i.putExtra("fecha",contacto.getFecha());
                i.putExtra("telefono",contacto.getTelefono());
                i.putExtra("email",contacto.getEmail());
                i.putExtra("descripcion",contacto.getDescripcion());
                startActivity(i);
            }
        });

        Bundle parametros = getIntent().getExtras();
        final String nombre2 = parametros.getString("nombre2");
        final String fecha2 = parametros.getString("fecha2");
        final String telefono2 = parametros.getString("telefono2");
        final String email2 = parametros.getString("email2");
        final String descripcion2 = parametros.getString("descripcion2");

        nombre.setText(nombre2);
        fecha.setText(fecha2);
        tel.setText(telefono2);
        email.setText(email2);
        descrip.setText(descripcion2);

    }

    private void colocar_fecha() {
        fecha.setText(dia + "/" + (mes + 1) + "/" + año+" ");
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    año = year;
                    mes = monthOfYear;
                    dia = dayOfMonth;
                    colocar_fecha();
                }
            };


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }
}