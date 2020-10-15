package com.kt.std.ipartnertest.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import com.kt.std.ipartnertest.model.entity.Note;
import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.SessionResponse;
import com.kt.std.ipartnertest.model.repo.NotesRepo;
import com.kt.std.ipartnertest.model.repo.SessionRepo;
import com.kt.std.ipartnertest.view.NoteRowView;
import com.kt.std.ipartnertest.view.MainView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.RequestBody;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    class NotesListPresenter implements INoteListPresenter {
        PublishSubject<NoteRowView> clickSubject = PublishSubject.create();
        List<Note> noteArrayList = new ArrayList<>();

        @Override
        public void bind(NoteRowView view) {
            Note note = noteArrayList.get(view.getPos());
            view.setBody(note.getBody());
            view.setDa(note.getDa());
            view.setDm(note.getDm());
        }

        @Override
        public int getCount() {
            return noteArrayList.size();
        }

        @Override
        public PublishSubject<NoteRowView> getClickSubject() {
            return clickSubject;
        }
    }

    private NotesRepo notesRepo;
    private SessionRepo sessionRepo;
    private Scheduler mainThreadScheduler;
    private String session;
    private NotesListPresenter notesListPresenter;

    public MainPresenter(Scheduler scheduler) {
        this.mainThreadScheduler = scheduler;
        this.notesRepo = new NotesRepo();
        this.notesListPresenter = new NotesListPresenter();
        this.sessionRepo = new SessionRepo();
        this.session = null;

    }

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();

        notesListPresenter.getClickSubject().subscribe(new Consumer<NoteRowView>() {
            @Override
            public void accept(NoteRowView noteRowView) throws Exception {
                Note note = notesListPresenter.noteArrayList.get(noteRowView.getPos());
                MainPresenter.this.getViewState().showMessage(note.getBody() + " " + note.getDm());
            }
        });
    }

    public INoteListPresenter getNotesListPresenter() {
        return notesListPresenter;
    }

    private ArrayList<Note> listNotesArrayList;

    @SuppressLint("CheckResult")
    public void loadNotes(RequestBody requestBody) {
        getViewState().showLoading();
        notesRepo.getListNotes(requestBody).observeOn(mainThreadScheduler).subscribe(new Consumer<ListNotes>() {
            @Override
            public void accept(ListNotes listNotes) throws Exception {
                MainPresenter.this.getViewState().hideLoading();
                listNotesArrayList = (ArrayList<Note>) listNotes.getData().get(0);

                notesListPresenter.noteArrayList.clear();
                notesListPresenter.noteArrayList.addAll(listNotesArrayList);
                MainPresenter.this.getViewState().updateList();

                for (Note note : listNotesArrayList) {
                    Log.d("resultNotes", note.getBody());
//                    getViewState().showMessage(note.getBody());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                MainPresenter.this.getViewState().hideLoading();
                MainPresenter.this.getViewState().showMessage(throwable.getMessage());
            }
        });

    }

    @SuppressLint("CheckResult")
    public void loadSession(RequestBody requestBody) {
        getViewState().showLoading();
        sessionRepo.getSession(requestBody).observeOn(mainThreadScheduler).subscribe(new Consumer<SessionResponse>() {
            @Override
            public void accept(SessionResponse sessionResponse) throws Exception {
                session = sessionResponse.getData().getSession();
                MainPresenter.this.getViewState().showMessage(session);
                MainPresenter.this.getViewState().saveSession(session);
                Log.d("rrrFromPresenter", session);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                MainPresenter.this.getViewState().hideLoading();
                MainPresenter.this.getViewState().showMessage(throwable.getMessage());
            }
        });
    }
}