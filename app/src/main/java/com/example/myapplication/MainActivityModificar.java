package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityModificar extends AppCompatActivity {

    Button btnCancelM;
    Button btnModificarM;
    Button btnAutocompleteM;

    EditText txtIdM;
    EditText txtNameM;
    EditText txtPriceM;
    EditText txtTypeM;
    EditText txtDesM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_modificar);

        btnCancelM = findViewById(R.id.buttonCancelarM);
        btnModificarM = findViewById(R.id.buttonModificarM);
        btnAutocompleteM = findViewById(R.id.buttonAutoCompleteM);

        txtIdM = (EditText) findViewById(R.id.editTextIdM);
        txtNameM = (EditText) findViewById(R.id.editTextNomM);
        txtPriceM = (EditText) findViewById(R.id.editTextPriceM);
        txtTypeM = (EditText) findViewById(R.id.editTextTipoM);
        txtDesM = (EditText) findViewById(R.id.editTextDesM);

        btnCancelM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnAutocompleteM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAutocompleteMClick(view);
            }
        });

        btnModificarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               btnModificarMClick(view);
            }
        });
    }

    public void btnModificarMClick(View v) {
        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "update articulo set nombre='"+txtNameM.getText().toString()+"', precio='"+txtPriceM.getText().toString()+"', tipo='"+txtTypeM.getText().toString()+"', descripcion='"+txtDesM.getText().toString()+"' where id='"+txtIdM.getText().toString()+"'";
        db.execSQL(sql);
        db.close();
        clear();
    }

    public void btnAutocompleteMClick(View v) {

        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "select * from articulo where id='"+txtIdM.getText().toString()+"'";
        Log.e("modal", sql);

        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();

        Log.e("modal", c.getString(1));
        Log.e("modal", c.getString(2));
        Log.e("modal", c.getString(3));
        Log.e("modal", c.getString(4));

        txtNameM.setText(c.getString(1));
        txtPriceM.setText(c.getString(2));
        txtTypeM.setText(c.getString(3));
        txtDesM.setText(c.getString(4));

        c.close();
        db.close();
    }

    public void clear() {
        txtIdM.setText("");
        txtNameM.setText("");
        txtPriceM.setText("");
        txtTypeM.setText("");
        txtDesM.setText("");
    }
}