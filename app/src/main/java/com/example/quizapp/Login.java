package com.example.quizapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.io.Serializable;
import java.util.ArrayList;


public class Login extends AppCompatActivity {

    // step1:Declaration
    EditText etLogin ,etPassword;
    Button bLogin;
    TextView tvRegister;
    FirebaseAuth fAuth;
    CallbackManager callbackManager;
    LoginButton loginButton;

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        //Step 2 :Recuperation des ids
        etLogin =(EditText)  findViewById(R.id.etLogin);
        etPassword =(EditText)  findViewById(R.id.etPassword);
        bLogin =(Button)  findViewById(R.id.bLogin);
        tvRegister =(TextView)  findViewById(R.id.tvRegister);

        fAuth=FirebaseAuth.getInstance();

        //Step 3 : Association de listeners (event)

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Login is Successfully ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Quiz1.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login Failed cancel ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Login Failed err ", Toast.LENGTH_SHORT).show();
            }

        });



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
                                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

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
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


}