package com.kt.std.rentateamtest.di

import com.kt.std.rentateamtest.activities.MainActivity
import com.kt.std.rentateamtest.fragments.UserListFragment
import com.kt.std.rentateamtest.mvp.presenter.UsersPresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(presenter: UsersPresenter)
    fun inject(fragment: UserListFragment)


}