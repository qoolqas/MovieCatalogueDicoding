package com.qoolqas.moviecatalogue.pojo.movie.videos;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class VideoMovieResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("results")
    private List<VideoResultsItem> results;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setResults(List<VideoResultsItem> results) {
        this.results = results;
    }

    public List<VideoResultsItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "VideoMovieResponse{" +
                        "id = '" + id + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}