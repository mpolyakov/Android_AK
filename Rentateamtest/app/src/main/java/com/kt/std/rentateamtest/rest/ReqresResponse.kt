package com.kt.std.rentateamtest.rest

data class Data(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val users: List<User>,
    val ad: Ad
)

data class Ad(
    val company: String,
    val url: String,
    val text: String
)

data class User(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)