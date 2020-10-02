package com.kt.std.gb_mvp_moxy.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value= AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void init();
    void updateList();

    void showMessage(String text);

    void showLoading();
    void hideLoading();
}
