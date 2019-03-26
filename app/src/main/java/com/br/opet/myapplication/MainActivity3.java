package com.br.opet.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity3 extends AppCompatActivity {

    private TextView textJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void downloadGSON(View view) {
        GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://swapi.co/api/films/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Filmes filme = gson.fromJson(response,Filmes.class);
                        textJSON.setText(filme.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textJSON.setText("Falha ao obter JSON");
                    }
                });

        queue.add(stringRequest);
    }

}
