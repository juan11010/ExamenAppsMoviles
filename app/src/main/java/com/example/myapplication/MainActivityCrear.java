package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityCrear extends AppCompatActivity {

    Button btnCancelC;
    Button btnCrearC;

    EditText txtNameC;
    EditText txtPriceC;
    EditText txtTypeC;
    EditText txtDesC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crear);

        btnCancelC = findViewById(R.id.buttonCancelarC);
        btnCrearC = findViewById(R.id.buttonCrearC);

        txtNameC = findViewById(R.id.editTextNomC);
        txtPriceC = findViewById(R.id.editTextPriceC);
        txtTypeC = findViewById(R.id.editTextTipoC);
        txtDesC = findViewById(R.id.editTextDesC);

        btnCrearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnCancelC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCancelClick(view);
            }
        });
    }

    public void btnCancelClick(View v) {
        Intent i = new Intent(this, MainActivityMenu.class);
        startActivity(i);
    }

    public void btnCreateClik(View v) {
        clearCreate();
    }

    public void clearCreate() {
        txtNameC.setText("");
        txtPriceC.setText("");
        txtTypeC.setText("");
        txtDesC.setText("");
    }
}