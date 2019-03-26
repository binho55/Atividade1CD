package com.br.opet.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.annotations.SerializedName;


public class Filmes extends AppCompatActivity {

    @SerializedName("episode_id")
    private long episode_id;
    private String title;
    private String opening_crawl;
    private String director;
    private String producer;
    private int produrelease_datecer;

    public Filmes() {
    }

    public long getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(long episode_id) {
        this.episode_id = episode_id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getProdurelease_datecer() {
        return produrelease_datecer;
    }

    public void setProdurelease_datecer(int produrelease_datecer) {
        this.produrelease_datecer = produrelease_datecer;
    }

    public Filmes(long episode_id, String title, String opening_crawl, String director, String producer, int produrelease_datecer ) {
        this.episode_id = episode_id;
        this.title = title;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.produrelease_datecer = produrelease_datecer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

}
