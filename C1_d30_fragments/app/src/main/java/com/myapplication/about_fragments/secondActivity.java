package com.myapplication.about_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }

        // Получим индекс из намерения активности
        Intent intent = getIntent();
        int buttonIndex = intent.getIntExtra("buttonIndex", -1);
        if (buttonIndex != -1) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment2 fragment2 = (Fragment2) fragmentManager
                    .findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }


}
