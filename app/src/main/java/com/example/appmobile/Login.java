package com.example.appmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Login extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        Button btn_login = findViewById(R.id.button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = findViewById(R.id.emailedit);
                EditText e2 = findViewById(R.id.usernameedit);
                EditText e3 = findViewById(R.id.passewordedit);
                String emaillogin = e1.getText().toString();
                String usernamelogin = e2.getText().toString();
                String passewordlogin = e3.getText().toString();

                Pattern p = Pattern.compile(".+@[a-z]+\\.[a-z]+$");
                Matcher m = p.matcher(emaillogin);
                boolean x=false,y=y=false;
                if(emaillogin.equals("") || usernamelogin.equals("") || passewordlogin.equals("")){
                    Toast.makeText(Login.this, "le champ est vide", Toast.LENGTH_SHORT).show();
                }
                else y=true;
                if(!m.matches()) {
                    Toast.makeText(Login.this, "email invalide", Toast.LENGTH_SHORT).show();
                }
                else x=true;


                Intent intent = new Intent(Login.this,MainActivity.class);
                if(x && y) startActivity(intent);
            }
        });
    }

}