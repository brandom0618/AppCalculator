package com.example.apipokemon.apimanager;

import com.example.apipokemon.models.HabilidadRespuesta;
import com.example.apipokemon.models.Pokemon;
import com.example.apipokemon.models.PokemonGenero;
import com.example.apipokemon.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://pokeapi.co/api/v2/";

    //END_POINTS
    @GET("pokemon")
    Call<PokemonRespuesta> getListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<Pokemon> getDetallePokemon(@Path("id") String id);

    @GET("gender/{id}")
    Call<PokemonGenero> getPokemonGenero(@Path("id") String id);

    @GET("ability/{id}")
    Call<HabilidadRespuesta> getPokemonHabilidad(@Path("id") String id);
}
