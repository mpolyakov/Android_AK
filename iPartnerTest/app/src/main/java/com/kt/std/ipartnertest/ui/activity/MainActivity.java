package com.kt.std.ipartnertest.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kt.std.ipartnertest.App;
import com.kt.std.ipartnertest.R;
import com.kt.std.ipartnertest.model.repo.RequestBodyRepo;
import com.kt.std.ipartnertest.presenter.MainPresenter;
import com.kt.std.ipartnertest.ui.adapter.NotesRVAdapter;
import com.kt.std.ipartnertest.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    NotesRVAdapter adapter;
    private String session;
    public static final String APP_PREFERENCES = "app_settings";
    public static final String APP_PREFERENCES_SESSION_ID = "session_id";
    public static SharedPreferences mSettings;
    Dialog noResponseProgressDialog;

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

    @Override
    protected void onResume() {
        super.onResume();
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        checkSessionLoadNotes();
    }

    private void checkSessionLoadNotes() {
        if (mSettings.contains(APP_PREFERENCES_SESSION_ID)) {
            session = mSettings.getString(APP_PREFERENCES_SESSION_ID, "");
        } else {
            presenter.loadSession(RequestBodyRepo.getRequestBody("a=new_session"));
        }
        presenter.loadNotes(RequestBodyRepo.getRequestBody("a=get_entries&session=" + session));
    }

    @ProvidePresenter
    public MainPresenter createPresenter() {
        presenter = new MainPresenter(AndroidSchedulers.mainThread());
        App.getInstance().getAppComponent().injectMain(presenter);
        return presenter;
    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesRVAdapter(presenter.getNotesListPresenter());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void saveSession(String sessionId) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_SESSION_ID, sessionId);
        editor.apply();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                Intent intent = new Intent(this, NoteCreateActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showNoResponseDialog() {
        if (noResponseProgressDialog == null) {
            noResponseProgressDialog = new AlertDialog.Builder(this)
                    .setPositiveButton(R.string.refresh, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            checkSessionLoadNotes();
                        }
                    })
                    .setNegativeButton(R.string.okbutton, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            noResponseProgressDialog.dismiss();
                        }
                    })
                    .setMessage(R.string.dialog_message)
                    .create();
        }
        noResponseProgressDialog.show();
    }

    @Override
    public void openNote(String body) {
        Intent intent = new Intent(MainActivity.this, NoteReadActivity.class);
        intent.putExtra("NOTE_BODY", body);
        startActivity(intent);
    }


}






















