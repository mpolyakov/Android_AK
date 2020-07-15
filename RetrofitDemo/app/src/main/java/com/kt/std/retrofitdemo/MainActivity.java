package com.kt.std.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.kt.std.retrofitdemo.model.CountryInfo;
import com.kt.std.retrofitdemo.model.Result;
import com.kt.std.retrofitdemo.service.CountryService;
import com.kt.std.retrofitdemo.service.RetrofitInstance;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Result> resultArrayList;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getCountries();
    }

    private Object getCountries() {
        CountryService countryService = RetrofitInstance.getService();
        Call<CountryInfo> call = countryService.getResults();

        call.enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {
                CountryInfo countryInfo = response.body();

                if (countryInfo != null && countryInfo.getRestResponse() != null){
                    resultArrayList = (ArrayList<Result>) countryInfo.getRestResponse().getResult();
                }

                for (Result result : resultArrayList){
                    Log.d("resultArrayList: ", result.getName());
                }

            }

            @Override
            public void onFailure(Call<CountryInfo> call, Throwable t) {

            }
        });
        return resultArrayList;
    }
}