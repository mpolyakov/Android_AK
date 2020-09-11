package com.kt.std.mvvmretrofitmoviapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kt.std.mvvmretrofitmoviapp.R;
import com.kt.std.mvvmretrofitmoviapp.databinding.ActivityMainBinding;
import com.kt.std.mvvmretrofitmoviapp.databinding.ActivityMovieDetailsBinding;
import com.kt.std.mvvmretrofitmoviapp.model.Result;

public class MovieDetailsActivity extends AppCompatActivity {
    private Result result;
    private ActivityMovieDetailsBinding activityMovieDetailsBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        activityMovieDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("movieData")){
            result = intent.getParcelableExtra("movieData");

            activityMovieDetailsBinding.setResult(result);
        }
    }
}