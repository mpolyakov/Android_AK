package com.kts.githubclient.mvp.presenter

import com.kts.githubclient.mvp.model.entity.GithubRepository
import com.kts.githubclient.mvp.model.repo.GithubRepositoriesRepo
import com.kts.githubclient.mvp.presenter.list.IRepositoryListPresenter
import com.kts.githubclient.mvp.view.RepositoriesView
import com.kts.githubclient.mvp.view.list.RepositoryItemView
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class RepositoriesPresenter(val repositoriesRepo: GithubRepositoriesRepo, val router: Router) : MvpPresenter<RepositoriesView>() {

    class RepositoryListPresenter : IRepositoryListPresenter {
        val repositories = mutableListOf<GithubRepository>()
        override var itemClickListener: ((RepositoryItemView) -> Unit)? = null

        override fun getCount() = repositories.size

        override fun bindView(view: RepositoryItemView) {
            val repository = repositories[view.pos]
            view.setTitle(repository.name)
        }
    }

    val repositoryListPresenter = RepositoryListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadRepos()

        repositoryListPresenter.itemClickListener = { itemView ->
            val repository = repositoryListPresenter.repositories[itemView.pos]

            //Практическое задание
            //router.replaceScreen(Screens.RepositoryScreen(repository))
        }
    }

    fun loadRepos() {
        repositoriesRepo.getRepos().let { repos ->
            repositoryListPresenter.repositories.clear()
            repositoryListPresenter.repositories.addAll(repos)
            viewState.updateList()
        }
    }

    fun backClicked() : Boolean {
        router.exit()
        return true
    }
}