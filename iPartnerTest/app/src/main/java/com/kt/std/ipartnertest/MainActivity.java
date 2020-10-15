package com.kt.std.ipartnertest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kt.std.ipartnertest.model.api.ApiHolder;
import com.kt.std.ipartnertest.model.api.IRetrofitInstance;
import com.kt.std.ipartnertest.model.entity.Note;
import com.kt.std.ipartnertest.model.entity.SessionResponse;
import com.kt.std.ipartnertest.presenter.MainPresenter;
import com.kt.std.ipartnertest.ui.NotesRVAdapter;
import com.kt.std.ipartnertest.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public RequestBody requestBody;
    public MediaType mediaType;
    NotesRVAdapter adapter;

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    @BindView(R.id.rl_loading)
    RelativeLayout loadingRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @ProvidePresenter
    public MainPresenter createPresenter() {
        return new MainPresenter(AndroidSchedulers.mainThread());
    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesRVAdapter(presenter.getNotesListPresenter());
        recyclerView.setAdapter(adapter);
        getNotes();
        getSession();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        loadingRelativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingRelativeLayout.setVisibility(View.GONE);
    }


    private void getSession() {
        presenter.loadSession(getRequestBody("a=new_session"));
    }

    private void getNotes() {
        presenter.loadNotes(getRequestBody("a=get_entries&session=pbkd2rcB43ctkhTHB9"));
    }

    private RequestBody getRequestBody(String params) {
        mediaType = MediaType.parse("application/x-www-form-urlencoded");
        requestBody = RequestBody.create(mediaType, params);
        return requestBody;
    }


}
