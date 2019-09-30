package com.myapplication.sherlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    public final static String THIEF = "ru.myapp.sherlock";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onRadioClick(View view) {
        Intent answerIntent = new Intent();

        switch (view.getId()){
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "коть");
                break;
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF, "ворона");
                break;
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "пёс");
                break;

                default:
                    break;

        }
        setResult(RESULT_OK, answerIntent);
        finish();
    }
}
