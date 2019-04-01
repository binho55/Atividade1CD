package com.br.opet.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private EditText username, password, password2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        mAuth = FirebaseAuth.getInstance();


    }


    protected void onStart() {

        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {

            Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Usuario nao Logado", Toast.LENGTH_SHORT).show();
        }


    }


    public void sigIN(View view) {

        String login = username.getText().toString();
        String senha = password.getText().toString();
        mAuth.signInWithEmailAndPassword(login, senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Sucesso", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, Telalogado.class);
                startActivity(intent);

            }

        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erro ao logar", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void register(View view) {
        String login = username.getText().toString();
        String senha = password.getText().toString();
        String confirmaSenha = password2.getText().toString();
        if (senha.length() >= 8) {
            mAuth.createUserWithEmailAndPassword(login, senha).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    telalogado();
                }
            }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Erro ao logar", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(this, "A senha precisa ter no mínimo 8 caracteres", Toast.LENGTH_LONG).show();
        }
    }

    public void telalogado() {
        Intent logado = new Intent(this, Telalogado.class);
        startActivity(logado);
    }
}



