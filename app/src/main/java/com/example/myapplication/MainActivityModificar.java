package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityModificar extends AppCompatActivity {

    Button btnCancelM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_modificar);

        btnCancelM = findViewById(R.id.buttonCancelarM);

        btnCancelM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCancelMClick(view);
            }
        });
    }

    public void btnCancelMClick(View v) {
        Intent i = new Intent(this, MainActivityMenu.class);
        startActivity(i);
    }
}