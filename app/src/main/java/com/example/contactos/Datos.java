package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString("nombre");
        final String fecha = parametros.getString("fecha");
        final String telefono = parametros.getString("telefono");
        final String email = parametros.getString("email");
        final String descripcion = parametros.getString("descripcion");

        TextView pnombre = (TextView) findViewById(R.id.textView8);
        TextView pfecha = (TextView) findViewById(R.id.textView13);
        TextView ptel = (TextView) findViewById(R.id.textView14);
        TextView pemail = (TextView) findViewById(R.id.textView15);
        TextView pdescrip = (TextView) findViewById(R.id.textView16);

        pnombre.setText(nombre);
        pfecha.setText(fecha);
        ptel.setText(telefono);
        pemail.setText(email);
        pdescrip.setText(descripcion);

        back = (Button) findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Datos.this,MainActivity.class);
                i.putExtra("nombre2",nombre);
                i.putExtra("fecha2",fecha);
                i.putExtra("telefono2",telefono);
                i.putExtra("email2",email);
                i.putExtra("descripcion2",descripcion);
                startActivity(i);
            }
        });

    }
}