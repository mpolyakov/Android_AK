package com.kt.std.mvvmretrofitmoviapp.service;

import com.kt.std.mvvmretrofitmoviapp.model.MovieApiResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<MovieApiResponce> getPopularMovies(@Query("api_key") String apiKey);

}
