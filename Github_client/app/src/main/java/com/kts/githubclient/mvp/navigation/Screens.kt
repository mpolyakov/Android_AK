package com.kts.githubclient.mvp.navigation

import com.kts.githubclient.mvp.model.entity.GithubRepository
import com.kts.githubclient.ui.fragments.RepositoriesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class RepositoriesScreen() : SupportAppScreen() {
        override fun getFragment() = RepositoriesFragment.newInstance()
    }

    class RepositoryScreen(val repository: GithubRepository) : SupportAppScreen() {
        //override fun getFragment() = RepositoryFragment.newInstance(repository)
    }

}