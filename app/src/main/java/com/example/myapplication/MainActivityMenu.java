package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityMenu extends AppCompatActivity {

    TextView txtAdmin;
    Button btnSalir;
    Button btnCrear;
    Button btnModificar;
    Button btnEliminar;
    Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        txtAdmin = findViewById(R.id.textViewAdmin);
        btnSalir = findViewById(R.id.buttonSalir);

        String nom = getIntent().getStringExtra("dato");
        String name = "Bienvenido \n" + nom;
        txtAdmin.setText(name);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSalirClick(view);
            }
        });
    }

    public void buttonSalirClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}