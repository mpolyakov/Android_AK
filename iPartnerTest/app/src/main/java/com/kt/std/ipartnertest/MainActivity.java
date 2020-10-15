package com.kt.std.ipartnertest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kt.std.ipartnertest.presenter.MainPresenter;
import com.kt.std.ipartnertest.ui.NotesRVAdapter;
import com.kt.std.ipartnertest.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public RequestBody requestBody;
    public MediaType mediaType;
    NotesRVAdapter adapter;
    private String session;
    public static final String APP_PREFERENCES = "app_settings";
    public static final String APP_PREFERENCES_SESSION_ID = "session_id";
    SharedPreferences mSettings;

    String sessionFromPresenter;

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

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @ProvidePresenter
    public MainPresenter createPresenter() {
        return new MainPresenter(AndroidSchedulers.mainThread());
    }

    @Override
    public void init() {
        if (mSettings.contains(APP_PREFERENCES_SESSION_ID)) {
            session = mSettings.getString(APP_PREFERENCES_SESSION_ID, "");
        } else {
            getSession();
        }
        getNotes(session);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesRVAdapter(presenter.getNotesListPresenter());
        recyclerView.setAdapter(adapter);
    }

    private void getSession() {
        presenter.loadSession(getRequestBody("a=new_session"));
    }

    @Override
    public void saveSession(String sessionId) {
        Log.d("resultNotes!", sessionId);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_SESSION_ID, session);
        editor.apply();
    }

    private void getNotes(String session) {
        presenter.loadNotes(getRequestBody("a=get_entries&session=" + session));
    }

    private RequestBody getRequestBody(String params) {
        mediaType = MediaType.parse("application/x-www-form-urlencoded");
        requestBody = RequestBody.create(mediaType, params);
        return requestBody;
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

}
