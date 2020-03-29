package com.kts.githubclient.mvp.presenter

import com.kts.gb_mvp.view.MainView
import com.kts.githubclient.mvp.model.repo.GithubRepositoriesRepo
import com.kts.githubclient.mvp.view.MainView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(val model: GithubRepositoriesRepo) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}