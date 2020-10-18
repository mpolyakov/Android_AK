package com.kt.std.ipartnertest.presenter;


import android.annotation.SuppressLint;

import com.kt.std.ipartnertest.model.entity.AddResponse;
import com.kt.std.ipartnertest.model.repo.AddRepo;
import com.kt.std.ipartnertest.view.NoteCreateView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.RequestBody;

@InjectViewState
public class NoteCreatePresenter extends MvpPresenter<NoteCreateView> {

    @Inject
    AddRepo addRepo;
    private Scheduler mainThreadScheduler;

    public NoteCreatePresenter(Scheduler scheduler) {
        this.mainThreadScheduler = scheduler;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    public void saveNote(RequestBody requestBody) {
        addRepo.getAddResponse(requestBody).observeOn(mainThreadScheduler).subscribe(new Consumer<AddResponse>() {
            @Override
            public void accept(AddResponse addResponse) throws Exception {
                String id = addResponse.getIdEntity().getId();
                if (id != null) {
                    NoteCreatePresenter.this.getViewState().showMessage("Note added successfull! Id is " + id);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                NoteCreatePresenter.this.getViewState().showMessage(throwable.getMessage());
            }
        });
    }

}
