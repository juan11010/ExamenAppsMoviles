package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityListar extends AppCompatActivity {

    Button btnSalirL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listar);

        btnSalirL = findViewById(R.id.buttonSalirL);

        btnSalirL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSalirLClick(view);
            }
        });
    }

    public void btnSalirLClick (View v) {
        Intent i = new Intent(this, MainActivityMenu.class);
        startActivity(i);
    }
}