package com.kt.std.ipartnertest.model.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private static ApiHolder instance = new ApiHolder();

    public static ApiHolder getInstance(){
        if(instance == null){
            instance = new ApiHolder();
        }
        return instance;
    }

    private INotesSource api;


    private ApiHolder(){
//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .excludeFieldsWithoutExposeAnnotation()
//                .create();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        api = new Retrofit.Builder()
                .baseUrl("https://bnet.i-partner.ru")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(INotesSource.class);
    }

    public static INotesSource getApi(){
        return getInstance().api;
    }
}