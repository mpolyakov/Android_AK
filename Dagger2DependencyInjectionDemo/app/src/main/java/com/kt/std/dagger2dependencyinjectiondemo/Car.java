package com.kt.std.dagger2dependencyinjectiondemo;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private CarEngine carEngine;
    private CarChassis carChassis;
    private CarBattery carBattery;

    @Inject
    public Car(CarEngine carEngine, CarChassis carChassis, CarBattery carBattery) {
        this.carEngine = carEngine;
        this.carChassis = carChassis;
        this.carBattery = carBattery;
    }

    public void setCarChassis(CarChassis carChassis) {
        this.carChassis = carChassis;
    }

    public void move(){
        Log.d("car move()", "Car is moving");
    }
}
