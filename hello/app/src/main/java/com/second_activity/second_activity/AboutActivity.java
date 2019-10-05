package com.second_activity.second_activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.myapplication.second_activity.R;


public class AboutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);
    }
}
