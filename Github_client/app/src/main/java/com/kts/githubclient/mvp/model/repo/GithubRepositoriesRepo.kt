package com.kts.githubclient.mvp.model.repo

import com.kts.githubclient.mvp.model.entity.GithubRepository

class GithubRepositoriesRepo {

    val repositories = listOf(
        GithubRepository("1", "name1", 100),
        GithubRepository("2", "name2", 200),
        GithubRepository("3", "name3", 300),
        GithubRepository("4", "name4", 400)
    )

    fun getRepos() = repositories
}