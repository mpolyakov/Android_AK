package com.kt.std.ipartnertest.di.module;

import com.kt.std.ipartnertest.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteListPresenterModule {
    @Provides
    public MainPresenter.NotesListPresenter provideNotesRepo(){
        return new MainPresenter.NotesListPresenter();
    }
}
