package com.kts.githubclient.mvp.presenter

import com.kts.githubclient.mvp.model.repo.GithubRepositoriesRepo
import com.kts.githubclient.mvp.navigation.Screens
import com.kts.githubclient.mvp.view.MainView
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        router.replaceScreen(Screens.RepositoriesScreen())
    }

    fun backClicked() {
        router.exit()
    }

}