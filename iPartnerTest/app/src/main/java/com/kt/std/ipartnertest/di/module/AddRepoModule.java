package com.kt.std.ipartnertest.di.module;

import com.kt.std.ipartnertest.model.repo.AddRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class AddRepoModule {
    @Provides
    public AddRepo provideAddRepo(){
        return new AddRepo();
    }
}
