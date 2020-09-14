package com.kt.std.mvvmretrofitmoviapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.kt.std.mvvmretrofitmoviapp.R;
import com.kt.std.mvvmretrofitmoviapp.service.MovieApiService;
import com.kt.std.mvvmretrofitmoviapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PageKeyedDataSource<Long, Result> {
    private MovieApiService movieApiService;
    private Application application;

    public MovieDataSource(MovieApiService movieApiService, Application application) {
        this.movieApiService = movieApiService;
        this.application = application;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, Result> callback) {

        movieApiService = RetrofitInstance.getService();
        Call<MovieApiResponce> call = movieApiService
                .getPopularMoviesWithPaging(application.getApplicationContext().getString(R.string.api_key), 1);

        call.enqueue(new Callback<MovieApiResponce>() {
            @Override
            public void onResponse(Call<MovieApiResponce> call, Response<MovieApiResponce> response) {
                MovieApiResponce movieApiResponce = response.body();
                ArrayList<Result> results = new ArrayList<>();

                if (movieApiResponce != null & movieApiResponce.getResults() != null) {
                    results = (ArrayList<Result>) movieApiResponce.getResults();
                    callback.onResult(results, null, (long)2);
                }



            }

            @Override
            public void onFailure(Call<MovieApiResponce> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Result> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull final LoadCallback<Long, Result> callback) {

        movieApiService = RetrofitInstance.getService();
        Call<MovieApiResponce> call = movieApiService
                .getPopularMoviesWithPaging(application.getApplicationContext().getString(R.string.api_key), params.key);

        call.enqueue(new Callback<MovieApiResponce>() {
            @Override
            public void onResponse(Call<MovieApiResponce> call, Response<MovieApiResponce> response) {
                MovieApiResponce movieApiResponce = response.body();
                ArrayList<Result> results = new ArrayList<>();

                if (movieApiResponce != null & movieApiResponce.getResults() != null) {
                    results = (ArrayList<Result>) movieApiResponce.getResults();
                    callback.onResult(results, params.key + 1);
                }


            }

            @Override
            public void onFailure(Call<MovieApiResponce> call, Throwable t) {

            }
        });
    }
}
