package com.kt.std.ipartnertest.model.repo;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RequestBodyRepo {

    public static RequestBody getRequestBody(String params) {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        return RequestBody.create(mediaType, params);
    }
}
