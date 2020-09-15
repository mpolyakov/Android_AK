package com.kt.std.dagger2dependencyinjectiondemo;

import dagger.Component;

@Component(modules = CarChassisModule.class)
public interface CarComponent {

    Car getCar();
}
