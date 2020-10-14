package com.kt.std.ipartnertest.presenter;

import android.util.Log;

import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.Note;
import com.kt.std.ipartnertest.model.repo.NotesRepo;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class MainPresenter {
    private NotesRepo notesRepo;
    ArrayList<Note> listNotesArrayList;

    public void getNotes(RequestBody requestBody) {
        notesRepo = new NotesRepo();
        notesRepo.getListNotes(requestBody).subscribe(new Consumer<ListNotes>() {
            @Override
            public void accept(ListNotes listNotes) throws Exception {
                if (listNotes != null && listNotes.getData() != null) {
                    listNotesArrayList = (ArrayList<Note>) listNotes.getData().get(0);
                }

                for (Note note : listNotesArrayList) {
                    Log.d("resultNotes", note.getBody());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

    }
}
