package com.kts.gb_mvp.presenter

import com.kts.gb_mvp.R
import com.kts.gb_mvp.model.CountersModel
import com.kts.gb_mvp.view.MainView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(val model: CountersModel) : MvpPresenter<MainView>() {

    fun counterClick1() {
        val nextValue = model.next(0)
        viewState.setButtonOneText(nextValue.toString())
    }

    fun counterClick2() {
        val nextValue = model.next(1)
        viewState.setButtonTwoText(nextValue.toString())
    }

    fun counterClick3() {
        val nextValue = model.next(2)
        viewState.setButtonThreeText(nextValue.toString())
    }

}