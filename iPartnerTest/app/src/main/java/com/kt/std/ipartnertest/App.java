package com.kt.std.ipartnertest;

import android.app.Application;

import com.kt.std.ipartnertest.di.AppComponent;
import com.kt.std.ipartnertest.di.DaggerAppComponent;

public class App extends Application {
    static private App instance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder().build();
    }

    public static App getInstance(){
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
