package com.kt.std.gb_mvp_moxy.mvp.model.api;


import com.kt.std.gb_mvp_moxy.mvp.model.entity.User;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface IDataSource {
    @GET("/users/{user}")
    Single<User> getUser(@Path("user") String username);
}
