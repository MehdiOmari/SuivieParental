package com.example.appmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Login extends AppCompatActivity {

    Button btn_login;
    FirebaseAuth auth;
    EditText e1;
    EditText e2;
    EditText e3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        btn_login = findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();
        e1 = findViewById(R.id.emailedit);
        e2 = findViewById(R.id.usernameedit);
        e3 = findViewById(R.id.passewordedit);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                if(x && y) {
                    loginUser(emaillogin , passewordlogin);
                }
            }
        });

        }
    private void loginUser(String email, String passeword){
        auth.createUserWithEmailAndPassword(email, passeword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "succeful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();

                }
                else Toast.makeText(Login.this, "failed authentification", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
