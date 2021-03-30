package com.example.quizapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;
import java.util.ArrayList;


public class Login extends AppCompatActivity {

    // step1:Declaration
    EditText etLogin ,etPassword;
    Button bLogin;
    TextView tvRegister;
    FirebaseAuth fAuth;

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Step 2 :Recuperation des ids
        etLogin =(EditText)  findViewById(R.id.etLogin);
        etPassword =(EditText)  findViewById(R.id.etPassword);
        bLogin =(Button)  findViewById(R.id.bLogin);
        tvRegister =(TextView)  findViewById(R.id.tvRegister);
        fAuth=FirebaseAuth.getInstance();

        //Step 3 : Association de listeners (event)
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Step 4 : Traitement

                if (isEmpty(etLogin)) {
                    etLogin.setError("Login is Required");
                    etLogin.requestFocus();
                }
                if (isEmpty(etPassword)) {
                    etPassword.setError("Password is Required");
                    etPassword.requestFocus();
                }
                if (!isEmpty(etLogin) && (!isEmpty(etPassword))) {
                    fAuth.signInWithEmailAndPassword(etLogin.getText().toString(), etPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Login is Successfully ", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), Quiz1.class));

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Login Failed : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }




}