package com.kt.std.dagger2dependencyinjectiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent = DaggerCarComponent.create();
        car = carComponent.getCar();

//        EngineFlap engineFlap = new EngineFlap();
//        CarBattery carBattery = new CarBattery();
//        CarChassis carChassis = new CarChassis();
//        CarEngine carEngine = new CarEngine(engineFlap);

//        Car car = new Car(carEngine, carChassis, carBattery);
        car.move();


    }
}