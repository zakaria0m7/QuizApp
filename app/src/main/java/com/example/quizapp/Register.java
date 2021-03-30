package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Register extends AppCompatActivity {

    EditText etName ,etMail ,etPassword,etConfirm;
    Button bSignup;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    List<User> listeUsers=new ArrayList<User>();

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        etName=(EditText) findViewById(R.id.etName);
        etMail=(EditText) findViewById(R.id.etMail);
        etPassword=(EditText) findViewById(R.id.etPassword);
        etConfirm=(EditText) findViewById(R.id.etConfirm);
        bSignup=(Button) findViewById(R.id.bRegister);



        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((!isEmpty(etName))&&(!isEmpty(etMail))&&(!isEmpty(etPassword))&&(!isEmpty(etConfirm)))
                {
                    if (etPassword.getText().toString().equals(etConfirm.getText().toString()))
                    {
                       mAuth.createUserWithEmailAndPassword(etMail.getText().toString(),etPassword.getText().toString())
                               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                   @Override
                                   public void onComplete(@NonNull Task<AuthResult> task) {
                                                   if(task.isSuccessful()){
                                                       User user = new User(etName.getText().toString(),etMail.getText().toString(),etPassword.getText().toString());

                                                       mDatabase.child("users").child(etName.getText().toString()).setValue(user);
                                                       Toast.makeText(getApplicationContext(),"User has been register successfully",Toast.LENGTH_SHORT).show();
                                                        startActivity(new Intent(getApplicationContext(),Login.class));
                                                        finish();
                                                   }
                                                   else{
                                                       Toast.makeText(Register.this, "User Authentication Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                   }
                                               }
                                           });

                                   }

                     else
                     {
                         etConfirm.setError("confirmation password does not match");
                         etConfirm.requestFocus();
                     }
                }

                 else
                 {
                     Toast.makeText(getApplicationContext(),"You missed some information!!",Toast.LENGTH_SHORT).show();
                 }


            }
        });
    }


}