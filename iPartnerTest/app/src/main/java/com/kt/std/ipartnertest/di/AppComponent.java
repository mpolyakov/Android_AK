package com.kt.std.ipartnertest.di;

import com.kt.std.ipartnertest.di.module.AddRepoModule;
import com.kt.std.ipartnertest.di.module.NoteListPresenterModule;
import com.kt.std.ipartnertest.di.module.NotesRepoModule;
import com.kt.std.ipartnertest.di.module.SessionRepoModule;
import com.kt.std.ipartnertest.presenter.MainPresenter;
import com.kt.std.ipartnertest.presenter.NoteCreatePresenter;

import dagger.Component;

@Component(modules = {NotesRepoModule.class, NoteListPresenterModule.class, SessionRepoModule.class, AddRepoModule.class})
public interface AppComponent {
    void injectMain(MainPresenter mainPresenter);
    void injectCreate(NoteCreatePresenter createPresenter);
}
