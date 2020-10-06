package com.kt.std.gb_mvp_moxy.mvp.model.repo;

import com.kt.std.gb_mvp_moxy.mvp.model.api.ApiHolder;
import com.kt.std.gb_mvp_moxy.mvp.model.entity.User;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class UsersRepo {
    public Single<User> getUser(String username) {
        return ApiHolder.getApi().getUser(username).subscribeOn(Schedulers.io());
    }
}
