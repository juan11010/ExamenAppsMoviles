package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUser;
    EditText txtPassword;
    ConexionSQLITE con;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnLogin = findViewById(R.id.buttonLogin);
        txtUser = findViewById(R.id.textUser);
        txtPassword = findViewById(R.id.textPass);
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLoginClick(view);
            }
        });
    }
    
    public void buttonLoginClick(View view) {

        ConexionSQLITE conn = new ConexionSQLITE(getApplicationContext(), "dbUsuario", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "select * from usuario where user = '"+ txtUser.getText().toString() +"'";

        String line = "";

        try {
            Cursor c = db.rawQuery(sql, null);
            while(c.moveToNext()) {
                if(c.getString(1).equals(txtPassword.getText().toString())) {
                    line = "ok";
                }
            }
            db.close();
        } catch (Exception ex) {
            db.close();
        }

        if(!line.equals("")) {
            Intent i = new Intent(this, MainActivityMenu.class);
            i.putExtra("user", txtUser.getText().toString());
            startActivity(i);
        } else {
            clearLogin();
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void clearLogin() {
        txtPassword.setText("");
        txtUser.setText("");
    }
}