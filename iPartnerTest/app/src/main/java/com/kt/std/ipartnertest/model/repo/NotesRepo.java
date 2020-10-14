package com.kt.std.ipartnertest.model.repo;

import com.kt.std.ipartnertest.model.api.ApiHolder;
import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.Note;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class NotesRepo {
    public Single<ListNotes> getListNotes(RequestBody requestBody) {
        return ApiHolder.getApi().getListNotes(requestBody).subscribeOn(Schedulers.io());
    }
}
