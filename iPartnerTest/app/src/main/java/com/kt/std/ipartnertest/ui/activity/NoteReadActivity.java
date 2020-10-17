package com.kt.std.ipartnertest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kt.std.ipartnertest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteReadActivity extends AppCompatActivity {


    @BindView(R.id.tvNote)
    TextView tvFullNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_read);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String body = getIntent().getStringExtra("NOTE_BODY");
        tvFullNote.setText(body);
    }
}