package com.kt.std.ipartnertest.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.Note;
import com.kt.std.ipartnertest.model.repo.NotesRepo;
import com.kt.std.ipartnertest.view.MainView;

import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private NotesRepo notesRepo;
    private ArrayList<Note> listNotesArrayList;
    private Scheduler mainThreadScheduler;
//    private CountriesRepo countriesRepo;
//    private CountriesListPresenter countriesListPresenter;

    public MainPresenter(Scheduler scheduler) {
        this.mainThreadScheduler = scheduler;
        this.notesRepo = new NotesRepo();

//        this.countriesRepo = new CountriesRepo();
//        this.countriesListPresenter = new CountriesListPresenter();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    public void loadNotes(RequestBody requestBody) {

        notesRepo.getListNotes(requestBody).observeOn(mainThreadScheduler).subscribe(new Consumer<ListNotes>() {
            @Override
            public void accept(ListNotes listNotes) throws Exception {
                if (listNotes != null && listNotes.getData() != null) {
                    listNotesArrayList = (ArrayList<Note>) listNotes.getData().get(0);
                }

                for (Note note : listNotesArrayList) {
                    Log.d("resultNotes", note.getBody());
                    getViewState().showMessage(note.getBody());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

    }
}
