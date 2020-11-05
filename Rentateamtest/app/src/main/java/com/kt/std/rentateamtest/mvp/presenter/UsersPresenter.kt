package com.kt.std.rentateamtest.mvp.presenter

import com.kt.std.rentateamtest.adapter.UsersAdapter
import com.kt.std.rentateamtest.di.App
import com.kt.std.rentateamtest.mvp.contract.UsersContract
import com.kt.std.rentateamtest.rest.UsersApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersPresenter : UsersContract.Presenter() {

    //внедряем источник данных
    @Inject
    lateinit var usersApi: UsersApi

    //инициализируем компоненты Даггера
    init {
        App.appComponent.inject(this)

    }

    //создаем список, загружая данные с помощью RxJava
    override fun makeList() {
        view.showProgress()

        //подписываемся на поток данных
        subscribe(usersApi.getUsers()

            //определяем отдельный поток для отправки данных
            .subscribeOn(Schedulers.io())

            //получаем данные в основном потоке
            .observeOn(AndroidSchedulers.mainThread())

            //преобразуем List<GeckoCoin> в Observable<GeckoCoin>
            .flatMap { Observable.fromIterable(it.users) }

            //наполняем поля элемента списка для адаптера
            .doOnNext {
                view.addUser(
                    UsersAdapter.User(
                        it.id,
                        it.email,
                        it.firstName,
                        it.lastName,
                        it.avatar
                    )
                )
            }

            //вызывается при вызове onComplete
            .doOnComplete {
                view.hideProgress()
            }

            //подписывает Observer на Observable
            .subscribe({
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }


    //обновляем список
    override fun refreshList() {
        view.refresh()
        makeList()
    }
}