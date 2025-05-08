package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText txt_user, txt_pass;
    Button btn_login;
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        txt_user = findViewById(R.id.txt_user);
        txt_pass = findViewById(R.id.txt_pass);
        btn_login = findViewById((R.id.btn_login));

        sharedPreferences = getSharedPreferences(dataUserCache, modo_private);
        editor = sharedPreferences.edit();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!txt_user.getText().toString().isEmpty()) || (!txt_pass.getText().toString().isEmpty())){
                    editor.putString("user", txt_user.getText().toString());
                    editor.commit();
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Login.this,"Por favor llenar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}