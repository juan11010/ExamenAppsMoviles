package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUser;
    EditText txtPassword;
    
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
        String user = txtUser.getText().toString();
        String pass = txtPassword.getText().toString();
        
        if (user.equals("admin") && pass.equals("1234")) {
//            Bundle parametros = new Bundle();
//            parametros.putString("dato", user);

            Intent i = new Intent(this, MainActivityMenu.class);
            i.putExtra("dato", user);
            startActivity(i);
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
        
    }
}