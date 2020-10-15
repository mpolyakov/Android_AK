package com.kt.std.ipartnertest.presenter;

import com.kt.std.ipartnertest.view.NoteRowView;

import io.reactivex.subjects.PublishSubject;

public interface INoteListPresenter {
    void bind(NoteRowView view);
    int getCount();
    PublishSubject<NoteRowView> getClickSubject();
}