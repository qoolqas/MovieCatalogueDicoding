package com.qoolqas.moviecatalogue.pojo.movie.image;

import com.google.gson.annotations.SerializedName;


public class PostersItem {

    @SerializedName("aspect_ratio")
    private double aspectRatio;

    @SerializedName("file_path")
    private String filePath;

    @SerializedName("vote_average")
    private int voteAverage;

    @SerializedName("width")
    private int width;

    @SerializedName("iso_639_1")
    private String iso6391;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("height")
    private int height;

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return
                "PostersItem{" +
                        "aspect_ratio = '" + aspectRatio + '\'' +
                        ",file_path = '" + filePath + '\'' +
                        ",vote_average = '" + voteAverage + '\'' +
                        ",width = '" + width + '\'' +
                        ",iso_639_1 = '" + iso6391 + '\'' +
                        ",vote_count = '" + voteCount + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}