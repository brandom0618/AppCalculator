package com.example.tallerconsumoapi.apimanager;

import com.example.tallerconsumoapi.models.Destileria;
import com.example.tallerconsumoapi.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://whiskyhunter.net/api/";

    //END_POINTS
    @GET("auctions_info")
    Call<List<Whisky>> getWhiskys();

    @GET("distilleries_info")
    Call<List<Destileria>> getDestilerias();

    @GET("auction_data/{slug}/")
    Call<List<Whisky>> getWhisky(@Path("slug") String slug);

    @GET("distillery_data/{slug}")
    Call<Destileria> getDestileria(@Path("slug") String slug);
}
