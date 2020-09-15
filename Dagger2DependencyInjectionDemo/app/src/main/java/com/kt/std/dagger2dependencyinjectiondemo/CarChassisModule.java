package com.kt.std.dagger2dependencyinjectiondemo;

import dagger.Module;
import dagger.Provides;

@Module
public class CarChassisModule {

    @Provides
    static CarChassis provideCarChassis(){
        return new CarChassis();
    }

}
