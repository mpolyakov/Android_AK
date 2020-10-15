package com.kt.std.ipartnertest.model.repo;

import com.kt.std.ipartnertest.model.api.ApiHolder;
import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.SessionResponse;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class SessionRepo {
    public Single<SessionResponse> getSession(RequestBody requestBody) {
        return ApiHolder.getApi().getSession(requestBody).subscribeOn(Schedulers.io());
    }
}
