package com.example.apipokemon.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Habilidad {
    @SerializedName("effect")
    private String effect;
    //private ArrayList<String> language;
    @SerializedName("short_effect")
    private String short_effect;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    /*public ArrayList<String> getLanguage() {
        return language;
    }

    public void setLanguage(ArrayList<String> language) {
        this.language = language;
    }*/

    public String getShort_effect() {
        return short_effect;
    }

    public void setShort_effect(String short_effect) {
        this.short_effect = short_effect;
    }
}
