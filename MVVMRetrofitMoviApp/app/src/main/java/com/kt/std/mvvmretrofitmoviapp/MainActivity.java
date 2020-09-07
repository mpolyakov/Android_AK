package com.kt.std.mvvmretrofitmoviapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kt.std.mvvmretrofitmoviapp.model.MovieApiResponce;
import com.kt.std.mvvmretrofitmoviapp.service.MovieApiService;
import com.kt.std.mvvmretrofitmoviapp.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPopularMovies();
    }


    public void getPopularMovies(){

        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<MovieApiResponce> call = movieApiService.getPopularMovies(getString(R.string.api_key));

        call.enqueue(new Callback<MovieApiResponce>() {
            @Override
            public void onResponse(Call<MovieApiResponce> call, Response<MovieApiResponce> response) {
                MovieApiResponce movieApiResponce = response.body();

            }

            @Override
            public void onFailure(Call<MovieApiResponce> call, Throwable t) {

            }
        });

    }


}