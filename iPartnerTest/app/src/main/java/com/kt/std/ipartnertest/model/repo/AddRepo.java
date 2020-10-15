package com.kt.std.ipartnertest.model.repo;

import com.kt.std.ipartnertest.model.api.ApiHolder;
import com.kt.std.ipartnertest.model.entity.AddResponse;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class AddRepo {
    public Single<AddResponse> getAddResponse(RequestBody requestBody) {
        return ApiHolder.getApi().getAddResponse(requestBody).subscribeOn(Schedulers.io());
    }
}
