package com.kt.std.mvvmretrofitmoviapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kt.std.mvvmretrofitmoviapp.model.MovieRepository;
import com.kt.std.mvvmretrofitmoviapp.model.Result;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);
    }

    public LiveData<List<Result>> getAllMovieData(){

        return movieRepository.getMutableLiveData();
    }
}
