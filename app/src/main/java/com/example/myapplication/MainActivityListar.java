package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivityListar extends AppCompatActivity {

    ArrayList<ModeloArticulo> articulos = new ArrayList<>();
    RecyclerView rc;
    Button btnSalirL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listar);

        btnSalirL = findViewById(R.id.buttonSalirL);
        rc = findViewById(R.id.recycleViewA);

        rc.setLayoutManager(new GridLayoutManager(this, 1));

        listar();

        AdapterDatos adapter = new AdapterDatos(articulos);
        rc.setAdapter(adapter);


        btnSalirL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void listar() {
        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();
        String sql = "select * from articulo";

        try {
            Cursor c = db.rawQuery(sql, null);
            while(c.moveToNext()) {
                articulos.add(new ModeloArticulo(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4)));
            }
            db.close();
        } catch (Exception ex) {
            db.close();
        }
    }
}