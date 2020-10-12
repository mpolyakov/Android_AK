package com.kt.std.ipartnertest.model.api;

import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.SessionResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface INotesSource {

        @Headers({
                "token: x916w01-mf-K2AODSh"
                ,"Content-Type: application/x-www-form-urlencoded"
        })
        @POST("/testAPI/")
        Call<SessionResponse> getSession(@Body RequestBody body);

//        Call<ListNotes> getListNotes(@Body RequestBody body);
}
