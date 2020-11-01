package com.kt.std.rentateamtest.rest

import io.reactivex.Observable
import retrofit2.http.GET

interface UsersApi {

    @GET("api/users")
    fun getUsers() : Observable<Data>

}