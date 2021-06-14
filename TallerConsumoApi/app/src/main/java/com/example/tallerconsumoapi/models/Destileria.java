package com.example.tallerconsumoapi.models;

import com.google.gson.annotations.SerializedName;

public class Destileria {


    @SerializedName("name")
    private String name;

    @SerializedName("slug")
    private String slug;

    @SerializedName("country")
    private String country;

    @SerializedName("whiskybase_rating")
    private String whiskyBaseRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWhiskyBaseRating() {
        return whiskyBaseRating;
    }

    public void setWhiskyBaseRating(String whiskyBaseRating) {
        this.whiskyBaseRating = whiskyBaseRating;
    }
}
