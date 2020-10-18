package com.kt.std.ipartnertest.di.module;

import com.kt.std.ipartnertest.model.repo.NotesRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class NotesRepoModule {
    @Provides
    public NotesRepo provideNotesRepo(){
        return new NotesRepo();
    }
}
