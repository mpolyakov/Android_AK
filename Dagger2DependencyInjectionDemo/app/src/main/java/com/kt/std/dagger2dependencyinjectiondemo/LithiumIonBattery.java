package com.kt.std.dagger2dependencyinjectiondemo;

import android.util.Log;

import javax.inject.Inject;

public class LithiumIonBattery implements CarBattery {

    @Inject
    public LithiumIonBattery() {
    }

    @Override
    public void logBatteryType() {
        Log.d("CarBattery", "This is a LithiumIonBattery");
    }
}
