package com.kt.std.ipartnertest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kt.std.ipartnertest.R;
import com.kt.std.ipartnertest.model.repo.RequestBodyRepo;
import com.kt.std.ipartnertest.presenter.MainPresenter;
import com.kt.std.ipartnertest.presenter.NoteCreatePresenter;
import com.kt.std.ipartnertest.view.NoteCreateView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.kt.std.ipartnertest.ui.activity.MainActivity.APP_PREFERENCES_SESSION_ID;

public class NoteCreateActivity extends MvpAppCompatActivity implements NoteCreateView {

    @InjectPresenter
    NoteCreatePresenter presenter;

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.buttonSave)
    Button buttonSave;

    @BindView(R.id.buttonCancel)
    Button buttonCancel;

    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_create);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (MainActivity.mSettings != null && MainActivity.mSettings.contains(APP_PREFERENCES_SESSION_ID)) {
            sessionId = MainActivity.mSettings.getString(APP_PREFERENCES_SESSION_ID, "");
        }
    }

    @ProvidePresenter
    public NoteCreatePresenter createPresenter() {
        return new NoteCreatePresenter(AndroidSchedulers.mainThread());
    }

    public void onCancelButtonClick(View view) {
        finish();
    }

    public void onSaveButtonClick(View view) {
        saveNote();
    }

    @Override
    public void saveNote() {
        Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_SHORT).show();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody requestBody = RequestBody.create(mediaType, "a=add_entry&session=" + sessionId + "&body=" + editText.getText().toString());
        presenter.saveNote(requestBody);
        finish();
    }


    @Override
    public void init() {

    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}