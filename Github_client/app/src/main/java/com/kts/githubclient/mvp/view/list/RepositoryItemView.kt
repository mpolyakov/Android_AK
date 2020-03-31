package com.kts.githubclient.mvp.view.list

interface RepositoryItemView {
    var pos: Int

    fun setTitle(text: String)
}