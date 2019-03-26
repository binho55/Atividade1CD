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

private EditText editLogin;
private EditText editSenha;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);


        firebaseAuth = FirebaseAuth.getInstance();


    }


    protected void onStart() {

        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

            Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this, "Usuario nao Logado", Toast.LENGTH_SHORT).show();
    }


    }



    public void sigIN(View view) {

        String login= editLogin.getText().toString();
        String senha = editSenha.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(login, senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Sucesso", Toast.LENGTH_LONG).show();

                Intent intent = new Intent (MainActivity.this, Main2Activity.class);
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

    public void Cadastro(View view) {

        String login= editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(login, senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
