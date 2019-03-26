package com.br.opet.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    private TextView textUser;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textUser = findViewById(R.id.emailMostrar);
        firebaseAuth = FirebaseAuth.getInstance();
    }





    protected void onStart() {

        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();

       textUser.setText(user.getEmail());



    }

    public void signOut(View view) {
        firebaseAuth.signOut();
        Intent intent =
                new Intent(Main2Activity.this, MainActivity.class
                        );
        startActivity(intent);

    }


}
