package com.kts.githubclient.mvp.presenter.list

import com.kts.githubclient.mvp.view.list.RepositoryItemView

interface IRepositoryListPresenter {
    var itemClickListener: ((RepositoryItemView) -> Unit)?
    fun getCount(): Int
    fun bindView(view: RepositoryItemView)
}