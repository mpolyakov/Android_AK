package com.kt.std.mvvmretrofitmoviapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.kt.std.mvvmretrofitmoviapp.R;
import com.kt.std.mvvmretrofitmoviapp.adapter.ResultAdapter;
import com.kt.std.mvvmretrofitmoviapp.model.MovieApiResponce;
import com.kt.std.mvvmretrofitmoviapp.model.Result;
import com.kt.std.mvvmretrofitmoviapp.service.MovieApiService;
import com.kt.std.mvvmretrofitmoviapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Result> results;
    private RecyclerView recyclerView;
    private ResultAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPopularMovies();

        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });
    }


    public void getPopularMovies(){

        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<MovieApiResponce> call = movieApiService.getPopularMovies(getString(R.string.api_key));

        call.enqueue(new Callback<MovieApiResponce>() {
            @Override
            public void onResponse(Call<MovieApiResponce> call, Response<MovieApiResponce> response) {
                MovieApiResponce movieApiResponce = response.body();

                if (movieApiResponce != null && movieApiResponce.getResults() != null ) {
                    results = (ArrayList<Result>) movieApiResponce.getResults();
                    fillRecyclerView();
                    swipeRefreshLayout.setRefreshing(false);
                }
                
            }

            @Override
            public void onFailure(Call<MovieApiResponce> call, Throwable t) {

            }
        });

    }

    private void fillRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ResultAdapter(this, results);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}