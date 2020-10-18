package com.kt.std.ipartnertest.di.module;

import com.kt.std.ipartnertest.model.repo.SessionRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class SessionRepoModule {
    @Provides
    public SessionRepo provideSessionRepo(){
        return new SessionRepo();
    }
}
