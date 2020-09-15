package com.kt.std.dagger2dependencyinjectiondemo;

import javax.inject.Inject;

public class CarEngine {
    private EngineFlap engineFlap;

    @Inject
    public CarEngine(EngineFlap engineFlap) {
        this.engineFlap = engineFlap;
    }
}
