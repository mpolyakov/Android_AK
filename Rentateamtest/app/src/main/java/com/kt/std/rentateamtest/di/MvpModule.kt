package com.kt.std.rentateamtest.di

import com.kt.std.rentateamtest.mvp.presenter.UsersPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {
    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): UsersPresenter = UsersPresenter()
}
