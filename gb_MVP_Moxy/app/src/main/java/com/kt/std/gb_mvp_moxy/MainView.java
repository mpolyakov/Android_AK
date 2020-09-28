package com.kt.std.gb_mvp_moxy;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value= AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void setTextToButton1(int value);
    void setTextToButton2(int value);
    void setTextToButton3(int value);
}
