package com.kt.std.ipartnertest.view;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface NoteCreateView extends MvpView {
    void saveNote();
    void showMessage(String text);
}
