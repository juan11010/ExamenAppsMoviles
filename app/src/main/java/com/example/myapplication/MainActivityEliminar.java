package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityEliminar extends AppCompatActivity {

    Button btnCancelE;
    Button btnEliminarE;
    Button btnAutocompleteE;

    EditText txtIdE;
    EditText txtNameE;
    EditText txtPriceE;
    EditText txtTypeE;
    EditText txtDesE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar);

        btnCancelE = findViewById(R.id.buttonCancelarE);
        btnEliminarE = findViewById(R.id.buttonEliminarE);
        btnAutocompleteE = findViewById(R.id.buttonAutoCompleteE);

        txtIdE = findViewById(R.id.editTextIdE);
        txtNameE = findViewById(R.id.editTextNomE);
        txtPriceE = findViewById(R.id.editTextPriceE);
        txtTypeE = findViewById(R.id.editTextTipoE);
        txtDesE = findViewById(R.id.editTextDesE);

        btnAutocompleteE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAutocompleteEClick(view);
            }
        });

        btnEliminarE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEliminarEClick(view);
            }
        });

        btnCancelE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void btnEliminarEClick(View v) {
        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "delete from articulo where id='"+txtIdE.getText().toString()+"'";
        db.execSQL(sql);
        db.close();
        clear();

    }

    public void btnAutocompleteEClick(View v) {

        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "select * from articulo where id='"+txtIdE.getText().toString()+"'";
        Log.e("modal", sql);

        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();

        Log.e("modal", c.getString(0));
        Log.e("modal", c.getString(1));
        Log.e("modal", c.getString(2));
        Log.e("modal", c.getString(3));
        Log.e("modal", c.getString(4));

        txtNameE.setText(c.getString(1));
        txtPriceE.setText(c.getString(2));
        txtTypeE.setText(c.getString(3));
        txtDesE.setText(c.getString(4));

        c.close();
        db.close();
    }

    public void clear() {
        txtIdE.setText("");
        txtNameE.setText("");
        txtPriceE.setText("");
        txtTypeE.setText("");
        txtDesE.setText("");
    }
}