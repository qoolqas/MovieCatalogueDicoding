package com.qoolqas.moviecatalogue.pojo.movie.image;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class PostersItem implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.aspectRatio);
        dest.writeString(this.filePath);
        dest.writeInt(this.voteAverage);
        dest.writeInt(this.width);
        dest.writeString(this.iso6391);
        dest.writeInt(this.voteCount);
        dest.writeInt(this.height);
    }

    public PostersItem() {
    }

    protected PostersItem(Parcel in) {
        this.aspectRatio = in.readDouble();
        this.filePath = in.readString();
        this.voteAverage = in.readInt();
        this.width = in.readInt();
        this.iso6391 = in.readString();
        this.voteCount = in.readInt();
        this.height = in.readInt();
    }

    public static final Parcelable.Creator<PostersItem> CREATOR = new Parcelable.Creator<PostersItem>() {
        @Override
        public PostersItem createFromParcel(Parcel source) {
            return new PostersItem(source);
        }

        @Override
        public PostersItem[] newArray(int size) {
            return new PostersItem[size];
        }
    };
}