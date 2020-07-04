package com.kt.std.yourlovelyfilms.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kt.std.yourlovelyfilms.model.AppRepository;
import com.kt.std.yourlovelyfilms.model.Genre;
import com.kt.std.yourlovelyfilms.model.Movie;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    AppRepository appRepository;
    private LiveData<List<Genre>> genres;
    private LiveData<List<Movie>> genreMovies;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
    }

    public LiveData<List<Genre>> getGenres() {
        genres = appRepository.getGenres();
        return genres;
    }

    public LiveData<List<Movie>> getGenreMovies(int genreId) {
        genreMovies = appRepository.getGenreMovies(genreId);
        return genreMovies;
    }

    public void addNewMovie(Movie movie){
        appRepository.insertMovie(movie);
    }

    public void updateMovie(Movie movie){
        appRepository.insertMovie(movie);
    }

    public void deleteMovie(Movie movie){
        appRepository.insertMovie(movie);
    }
}


















