package com.kts.githubclient.mvp.model.entity


class GithubRepository(
    val id: String,
    val name: String,
    val forksCount: Int
)


//https://api.github.com/users/googlesamples/repos