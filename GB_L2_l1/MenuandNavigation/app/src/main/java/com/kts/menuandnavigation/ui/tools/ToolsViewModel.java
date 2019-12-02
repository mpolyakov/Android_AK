package com.kts.menuandnavigation.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Здесь вы можете изменить настройки приложения");
    }

    public LiveData<String> getText() {
        return mText;
    }
}