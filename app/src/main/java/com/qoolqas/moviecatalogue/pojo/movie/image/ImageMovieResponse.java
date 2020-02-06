package com.qoolqas.moviecatalogue.pojo.movie.image;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ImageMovieResponse {

    @SerializedName("backdrops")
    private List<BackdropsItem> backdrops;

    @SerializedName("posters")
    private List<PostersItem> posters;

    @SerializedName("id")
    private int id;

    public void setBackdrops(List<BackdropsItem> backdrops) {
        this.backdrops = backdrops;
    }

    public List<BackdropsItem> getBackdrops() {
        return backdrops;
    }

    public void setPosters(List<PostersItem> posters) {
        this.posters = posters;
    }

    public List<PostersItem> getPosters() {
        return posters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "ImageMovieResponse{" +
                        "backdrops = '" + backdrops + '\'' +
                        ",posters = '" + posters + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}