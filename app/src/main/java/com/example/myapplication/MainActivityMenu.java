package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityMenu extends AppCompatActivity {

    TextView txtUsr;
    Button btnSalir;
    Button btnCrear;
    Button btnModificar;
    Button btnEliminar;
    Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        txtUsr = findViewById(R.id.textViewAdmin);
        btnSalir = findViewById(R.id.buttonSalir);
        btnCrear = findViewById(R.id.buttonCrear);
        btnModificar = findViewById(R.id.buttonModificar);
        btnEliminar = findViewById(R.id.buttonEliminar);
        btnListar = findViewById(R.id.buttonListar);

        // TODO Hacer que funcione en todos los casos
        String usr = getIntent().getStringExtra("user");
        String user = "Bienvenido \n" + usr;
        txtUsr.setText(user);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSalirClick(view);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCrearClick(view);
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonModificarClick(view);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonEliminarClick(view);
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonListarClick(view);
            }
        });
    }

    public void buttonSalirClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void buttonCrearClick(View v) {
        Intent i = new Intent(this, MainActivityCrear.class);
        startActivity(i);
    }

    public void buttonModificarClick(View v) {
        Intent i = new Intent(this, MainActivityModificar.class);
        startActivity(i);
    }

    public void buttonEliminarClick(View v) {
        Intent i = new Intent(this, MainActivityEliminar.class);
        startActivity(i);
    }

    public void buttonListarClick(View v) {
        Intent i = new Intent(this, MainActivityListar.class);
        startActivity(i);
    }
}