package com.qoolqas.moviecatalogue.pojo.tv.detail;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class NetworksItem {

    @SerializedName("logo_path")
    private String logoPath;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("origin_country")
    private String originCountry;

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    @Override
    public String toString() {
        return
                "NetworksItem{" +
                        "logo_path = '" + logoPath + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",origin_country = '" + originCountry + '\'' +
                        "}";
    }
}