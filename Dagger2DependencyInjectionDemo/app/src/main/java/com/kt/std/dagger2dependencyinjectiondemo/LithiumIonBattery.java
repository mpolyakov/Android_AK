package com.kt.std.dagger2dependencyinjectiondemo;

import android.util.Log;

import javax.inject.Inject;

public class LithiumIonBattery implements CarBattery {
    private static final String TAG = "carTag";

    @Inject
    public LithiumIonBattery() {
    }

    @Override
    public void logBatteryType() {
        Log.d("carTag", "This is a LithiumIonBattery");
    }
}
