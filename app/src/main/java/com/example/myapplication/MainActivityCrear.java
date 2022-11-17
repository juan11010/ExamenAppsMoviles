package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        btnCancelC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCrearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCreateClik(view);
            }
        });
    }

    public void btnCreateClik(View v) {
        int index = ultimo();
        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "insert into articulo values ('"+ index +"', '"+ txtNameC.getText().toString() +"', '"+ txtPriceC.getText().toString() +"', '"+txtTypeC.getText().toString()+"', '"+txtDesC.getText().toString()+"')";
        db.execSQL(sql);
        finish();
    }

    public int ultimo() {
        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "select count(*) total from articulo";
        int index = 0;

        try {
            Cursor c = db.rawQuery(sql, null);
            while(c.moveToNext()) {
                index = Integer.parseInt(c.getString(0));
            }
            c.close();
            db.close();
        } catch (Exception ex) {
            db.close();
        }
        return index;
    }
}