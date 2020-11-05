package com.kt.std.rentateamtest.mvp.contract

import com.kt.std.rentateamtest.adapter.UsersAdapter

class UsersContract {
    interface View : BaseContract.View {
        fun addUser(user: UsersAdapter.User)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter: BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}